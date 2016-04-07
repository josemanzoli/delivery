package com.walmart.delivery.rest.api.to;

/**
 * Transfer Object that returns an output with the calculation result of the dikjsktra algorithm
 *  
 * @author josemanzoli
 * 
 */
public class ShortestPathOutputTO extends BaseOutputTO{

	private static final long serialVersionUID = 1L;

	private String cities;
	private Double minimumCost;
	
	public String getCities() {
		return cities;
	}
	
	public void setCities(String cities) {
		this.cities = cities;
	}
	
	public Double getMinimumCost() {
		return minimumCost;
	}
	
	public void setMinimumCost(Double minimumCost) {
		this.minimumCost = minimumCost;
	}
}