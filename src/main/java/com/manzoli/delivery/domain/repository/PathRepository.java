package com.manzoli.delivery.domain.repository;

import java.util.Set;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.delivery.domain.City;
import com.manzoli.delivery.domain.Path;

/**
 * Repository for Relationships between cities
 *  
 * @author josemanzoli
 * 
 */
@Repository
public interface PathRepository extends GraphRepository<Path>{

	public Set<Path> findAllByFrom(City from);
}