package com.walmart.delivery.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walmart.delivery.domain.City;
import com.walmart.delivery.domain.Path;
import com.walmart.delivery.domain.repository.PathRepository;

/**
 * Provided services for Pathrepository
 *  
 * @author josemanzoli
 * @since 2014-09-20
 * 
 */
@Service
@Transactional
public class PathServiceImpl {
	
	@Autowired
	private PathRepository pathRepository;

	@Transactional
	public Path savePath(Path path){
		return pathRepository.save(path);
	}
	
	public Set<Path> findAllByCity(City from){
		return pathRepository.findAllByFrom(from);
	}
}
