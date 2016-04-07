package com.walmart.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walmart.delivery.domain.City;
import com.walmart.delivery.domain.repository.CityRepository;

/**
 * Provided services for CityRepository
 *  
 * @author josemanzoli
 * 
 */
@Service
@Transactional
public class CityServiceImpl {

	@Autowired
	private CityRepository cityRepository;

	@Transactional
	public City saveCity(String name, String state){
		City city = cityRepository.findByName(name);
		if (city!=null){
			return city;
		}
		return cityRepository.save(new City(name, state));
	}
	
	@Transactional
	public City saveCity(City city){
		return cityRepository.save(city);
	}

	public List<City> findByState(String state) {
		return cityRepository.findByState(state);
	}
	
	public City findByName(String name){
		return cityRepository.findByName(name);
	}
	
	@Transactional
	public void deleteAll(){
		cityRepository.deleteAll();
	}
}
