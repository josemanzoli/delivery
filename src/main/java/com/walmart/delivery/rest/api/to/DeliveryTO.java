package com.walmart.delivery.rest.api.to;

import java.util.List;

/**
 * Transfer Object that receives the input of a delivery map representation
 * 
 * @author josemanzoli
 */
public class DeliveryTO {

	private String stateName;
	private List<RouteTO> routes;

	public DeliveryTO() {

	}

	public DeliveryTO(String stateName, List<RouteTO> routes) {
		this.stateName = stateName;
		this.setRoutes(routes);
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<RouteTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<RouteTO> routes) {
		this.routes = routes;
	}

}