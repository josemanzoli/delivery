package com.walmart.delivery.rest.api.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Transfer Object that returns an output list of cities
 *  
 * @author josemanzoli
 * @since 2014-09-20
 * 
 */
public class ListStateOutputTO extends BaseOutputTO{

	private static final long serialVersionUID = -7169874414320345734L;

	private List<String> cities;

	public List<String> getCities() {
		if (this.cities == null){
			cities = new ArrayList<String>();
		}
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
}
