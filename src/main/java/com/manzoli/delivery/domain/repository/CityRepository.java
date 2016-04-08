package com.manzoli.delivery.domain.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.delivery.domain.City;

/**
 * Repository for City Entity
 *  
 * @author josemanzoli
 * 
 */
@Repository
public interface CityRepository extends GraphRepository<City>{

	public City findByName(String name);
	public List<City> findByState(String state);
}
