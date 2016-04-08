package com.manzoli.delivery.rest.api.to;

/**
 * Transfer Object that returns an output of the TriangleType
 * 
 * @author josemanzoli
 * 
 */
public class TriangleOutputTO extends BaseOutputTO {
	
	private static final long serialVersionUID = 7864684780601874155L;
	
	private String triangleType;
	
	public TriangleOutputTO(){
		
	}
	
	public TriangleOutputTO(String triangleType){
		this.setTriangleType(triangleType);
	}

	public String getTriangleType() {
		return triangleType;
	}

	public void setTriangleType(String triangleType) {
		this.triangleType = triangleType;
	}

	@Override
	public String toString() {
		return "TriangleOutputTO [triangleType=" + triangleType + "]";
	}
	
	
	
}