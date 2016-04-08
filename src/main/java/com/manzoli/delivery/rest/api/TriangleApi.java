package com.manzoli.delivery.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manzoli.delivery.domain.Triangle;
import com.manzoli.delivery.enumerate.TriangleType;
import com.manzoli.delivery.rest.api.to.TriangleOutputTO;
import com.manzoli.delivery.service.impl.TriangleServiceImpl;


/**
 * Rest API used to receive the 3 sides of a triangle and return the type of the triangle 
 *  
 * @author josemanzoli
 * 
 */
@RestController
@RequestMapping(value="/triangleService")
public class TriangleApi {
	
	@Autowired
	private TriangleServiceImpl triangleServices;
	
	@RequestMapping(value="/classifyTriangle", method=RequestMethod.POST, headers = { "Accept=application/json", "content-type=application/json" })
	public TriangleOutputTO classifyTriangle(@RequestBody final Triangle triangle){
		TriangleOutputTO triangleOutputTO = new TriangleOutputTO();;
		try {
			TriangleType triangleType = triangleServices.classify(triangle);
			triangleOutputTO.success();
			triangleOutputTO.setTriangleType(triangleType.toString());
		} catch (Exception e) {
			triangleOutputTO.error();
		}
		return triangleOutputTO;
	}
	
}