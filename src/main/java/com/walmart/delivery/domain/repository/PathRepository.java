package com.walmart.delivery.domain.repository;

import java.util.Set;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.walmart.delivery.domain.City;
import com.walmart.delivery.domain.Path;

/**
 * Repository for Relationships between cities
 *  
 * @author josemanzoli
 * @since 2014-09-20
 * 
 */
@Repository
public interface PathRepository extends GraphRepository<Path>{

	public Set<Path> findAllByFrom(City from);
}