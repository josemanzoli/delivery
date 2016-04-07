package com.walmart.delivery.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.delivery.domain.City;
import com.walmart.delivery.rest.api.to.BaseOutputTO;
import com.walmart.delivery.rest.api.to.DeliveryTO;
import com.walmart.delivery.rest.api.to.ListStateOutputTO;
import com.walmart.delivery.rest.api.to.ShortestPathOutputTO;
import com.walmart.delivery.service.impl.CityServiceImpl;
import com.walmart.delivery.service.impl.DeliveryServiceImpl;


/**
 * Rest API used to receive data in form of a State Map, persists the data, returns all the persisted data and 
 * gives you the minimum cost based on parameters.
 *  
 * @author josemanzoli
 * 
 */
@RestController
@RequestMapping(value="/deliveryService")
public class DeliveryApi {
	
	@Autowired
	private DeliveryServiceImpl deliveryServices;
	
	@Autowired
	private CityServiceImpl cityService;
	
	@RequestMapping(value="/saveMap", method=RequestMethod.PUT, headers = { "Accept=application/json", "content-type=application/json" })
	public BaseOutputTO saveMap(@RequestBody final DeliveryTO deliveryTO){
		BaseOutputTO baseOutputTO;
		try {
			baseOutputTO = deliveryServices.saveMap(deliveryTO);
		} catch (Exception e) {
			baseOutputTO = new BaseOutputTO();
			baseOutputTO.error();
		}
		return baseOutputTO;
	}
	
	@RequestMapping(value = "/findByState", method = RequestMethod.GET)
	public ListStateOutputTO findByState(
			@RequestParam(value = "state", required = true) String state) {
		ListStateOutputTO ret = new ListStateOutputTO();
		try {
			List<City> cities = cityService.findByState(state);
			for(City city : cities){
				ret.getCities().add(city.toString());
			}
			ret.success();
		} catch (Exception e) {
			ret.error();
		}
		return ret;
	}
	
	@RequestMapping(value = "/shortestPath", method = RequestMethod.GET)
	public ShortestPathOutputTO getShortestPath(
			@RequestParam(value = "mapName", required = true) String mapName,
			@RequestParam(value = "sourceName", required = true) String sourceName,
			@RequestParam(value = "destinationName", required = true) String destinationName,
			@RequestParam(value = "price", required = true, defaultValue = "0.0") Double price,
			@RequestParam(value = "autonomy", required = true, defaultValue = "1.0") Double autonomy) {
		ShortestPathOutputTO ret;
		try {
			ret = deliveryServices.buildShortestPath(mapName,sourceName, destinationName, price, autonomy);
			ret.success();
		} catch (Exception e) {
			ret = new ShortestPathOutputTO();
			ret.error();
		}
		return ret;
	}
	
	@RequestMapping(value = "/removeCities", method = RequestMethod.DELETE)
	public BaseOutputTO removeCities() {
		BaseOutputTO ret = new BaseOutputTO();
		try {
			cityService.deleteAll();
			ret.success();
		} catch (Exception e) {
			ret.error();
		}
		return ret;
	}
}