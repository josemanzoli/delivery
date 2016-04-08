package com.manzoli.delivery.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;
import com.manzoli.delivery.domain.City;
import com.manzoli.delivery.domain.Path;
import com.manzoli.delivery.rest.api.to.BaseOutputTO;
import com.manzoli.delivery.rest.api.to.DeliveryTO;
import com.manzoli.delivery.rest.api.to.RouteTO;
import com.manzoli.delivery.rest.api.to.ShortestPathOutputTO;

import es.usc.citius.hipster.algorithm.Algorithm.SearchResult;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.graph.GraphSearchProblem;
import es.usc.citius.hipster.util.graph.HashBasedHipsterDirectedGraph;

/**
 * Aggregation of services and Business Rules implementations, you can call this class "The heart of the solution" 
 *  
 * @author josemanzoli
 * 
 */
@Service
@Transactional
public class DeliveryServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);
	
	@Autowired
	private CityServiceImpl cityService;
	
	@Autowired
	private PathServiceImpl pathService;
	
	@Transactional
	public BaseOutputTO saveMap(DeliveryTO deliveryTO){
		
		logger.debug(" STATE = {}",deliveryTO.getStateName());
		
		for (RouteTO route : deliveryTO.getRoutes()){
			logger.debug(" FROM = {}",route.getFrom());
			logger.debug(" TO = {}",route.getTo());
			logger.debug(" DISTANCE = {}", route.getDistance());
			
			saveRoute(route, deliveryTO.getStateName());
		}
		BaseOutputTO baseOutputTO = new BaseOutputTO();
		baseOutputTO.created();
		return baseOutputTO;
	}
	
	
	private void saveRoute(RouteTO route, String state){
		
		City from = cityService.saveCity(route.getFrom(), state);
		City to = cityService.saveCity(route.getTo(), state);
		
		logger.debug(" FROM PERSISTED = {}, TO PERSISTED= {} ",from, to);
		
		Path path = new Path(from, to, route.getDistance());
		from.getCitiesThatHavePaths().add(pathService.savePath(path));
		
		logger.debug(" Path created = From = {} --- To = {} ",path.getFrom().getName(), path.getTo().getName());
		
		cityService.saveCity(from);
	}
	
	public ShortestPathOutputTO buildShortestPath(String state, String from, String to, Double price, Double autonomy){
		
		List<City> cities = cityService.findByState(state);
		Set<Path> paths = new HashSet<Path>();
		
		for (City city : cities){
			paths.addAll(city.getCitiesThatHavePaths());
		}
		
		ShortestPathOutputTO ret = findShortestPathByDijkstra(Sets.newHashSet(paths), from, to);
		
		Double distance = ret.getMinimumCost();
		
		logger.debug(" distance = {} autonomy = {} price = {}",distance ,autonomy, price);
		
		Double minumumCost = distance/autonomy * price;
		
		ret.setMinimumCost(minumumCost);
		return ret;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ShortestPathOutputTO findShortestPathByDijkstra(Set<Path> paths, String from, String to){
		
		ShortestPathOutputTO ret = new ShortestPathOutputTO();
		
		logger.debug(" Paths size = {}",paths.size());
		logger.debug("Initiating calculation");
		logger.debug(" From = {} To = {} ",from,to);
		
		HashBasedHipsterDirectedGraph<String,Double> graph = HashBasedHipsterDirectedGraph.create();
		for (Path path : paths){
			logger.debug(" From = {} --- To = {} ",path.getFrom().getName(), path.getTo().getName());
			
			graph.connect(path.getFrom().getName(), path.getTo().getName(), path.getDistance());
		}	     
		
		SearchProblem p = GraphSearchProblem
                .startingFrom(from)
                .in(graph)
                .takeCostsFromEdges()
                .build();

		SearchResult searchResult =  Hipster.createDijkstra(p).search(to);
		logger.debug("SearchResult = {} ",searchResult.toString());

		//workaround for jackson api giving an error to convert LinkedList - searchResult.getOptimalPaths()
		//I lost to much time resolving a persistence problem to Fetch the EndNodes. So thats not a correct thing but it gives you the result!
		String bestPath = searchResult.getOptimalPaths().toString();
		
		List<WeightedNode> nodes = new ArrayList<WeightedNode>(searchResult.getGoalNodes());
		logger.debug("Wheigted nodes = {} ",nodes.toString());
		
		Double distance = Double.valueOf(nodes.get(0).getCost().toString());
		
		ret.setCities(bestPath);
		ret.setMinimumCost(distance);
		return ret;
	} 
}
