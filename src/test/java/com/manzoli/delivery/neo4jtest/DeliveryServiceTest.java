package com.manzoli.delivery.neo4jtest;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manzoli.delivery.domain.City;
import com.manzoli.delivery.domain.Path;
import com.manzoli.delivery.domain.repository.CityRepository;
import com.manzoli.delivery.rest.api.to.ShortestPathOutputTO;
import com.manzoli.delivery.service.impl.CityServiceImpl;
import com.manzoli.delivery.service.impl.DeliveryServiceImpl;

/**
 * Demonstration of a test for DeliveryService
 * Used to prove that the algorithm really works
 *  
 * @author josemanzoli
 * 
 */
public class DeliveryServiceTest {
	
	@InjectMocks
	private DeliveryServiceImpl deliveryService;
	
	@Mock
	private CityServiceImpl cityService;
	
	@Mock
	private CityRepository cityRepository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void buildShortestPath(){
		List<City> cities = buildCities();
		when(cityService.findByState("SP")).thenReturn(cities);
		ShortestPathOutputTO sp = deliveryService.buildShortestPath("SP", "A", "D", 2.5, 10.0);
		Assert.assertEquals(sp.getCities(),"[[A, B, D]]");
		
		Assert.assertEquals((Double)6.25,sp.getMinimumCost());
	}
	
	private List<City> buildCities() {
		City cityA = new City("A","SP");
		City cityB = new City("B","SP");
		City cityC = new City("C","SP");
		City cityD = new City("D","SP");
		City cityE = new City("E","SP");
		cityA.getCitiesThatHavePaths().add(new Path(cityA, cityB, 10.0));
		cityB.getCitiesThatHavePaths().add(new Path(cityB, cityD, 15.0));
		cityA.getCitiesThatHavePaths().add(new Path(cityA, cityC, 20.0));
		cityC.getCitiesThatHavePaths().add(new Path(cityC, cityD, 30.0));
		cityB.getCitiesThatHavePaths().add(new Path(cityB, cityE, 50.0));
		cityD.getCitiesThatHavePaths().add(new Path(cityD, cityE, 30.0));
		List<City> cities = new ArrayList<City>();
		cities.add(cityA);
		cities.add(cityB);
		cities.add(cityC);
		cities.add(cityD);
		cities.add(cityE);
		return cities;
	}
}
