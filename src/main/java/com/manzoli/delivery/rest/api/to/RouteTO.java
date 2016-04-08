package com.manzoli.delivery.rest.api.to;

/**
 * Transfer Object that receives the input of a specific route
 * 
 * @author josemanzoli
 * 
 */
public class RouteTO {
	
	private String from;
	private String to;
	private Double distance;
	
	public RouteTO(){
		
	}
	
	public RouteTO(String from, String to, Double distance){
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public Double getDistance() {
		return distance;
	}
	
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RouteTO [from=" + from + ", to="
				+ to + ", distance=" + distance + "]";
	}
	
}