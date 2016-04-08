package com.manzoli.delivery.domain;

import com.manzoli.delivery.enumerate.TriangleType;

/**
 * POJO class to represent any Triangle.
 * 
 * @author Jose Luiz Manzoli
 *
 */
public class Triangle {
	
	private Integer sideOne;
	private Integer sideTwo;
	private Integer sideThree;
	private TriangleType triangleType;
	
	public Triangle(){
		
	}
	
	public Triangle(Integer sideOne, Integer sideTwo, Integer sideThree){
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
	}
	
	public Integer getSideOne() {
		return sideOne;
	}
	
	public void setSideOne(Integer sideOne) {
		this.sideOne = sideOne;
	}
	
	public Integer getSideTwo() {
		return sideTwo;
	}
	
	public void setSideTwo(Integer sideTwo) {
		this.sideTwo = sideTwo;
	}
	
	public Integer getSideThree() {
		return sideThree;
	}
	
	public void setSideThree(Integer sideThree) {
		this.sideThree = sideThree;
	}
	
	public TriangleType getTriangleType() {
		return triangleType;
	}
	
	public void setTriangleType(TriangleType triangleType) {
		this.triangleType = triangleType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sideOne == null) ? 0 : sideOne.hashCode());
		result = prime * result
				+ ((sideThree == null) ? 0 : sideThree.hashCode());
		result = prime * result + ((sideTwo == null) ? 0 : sideTwo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (sideOne == null) {
			if (other.sideOne != null)
				return false;
		} else if (!sideOne.equals(other.sideOne))
			return false;
		if (sideThree == null) {
			if (other.sideThree != null)
				return false;
		} else if (!sideThree.equals(other.sideThree))
			return false;
		if (sideTwo == null) {
			if (other.sideTwo != null)
				return false;
		} else if (!sideTwo.equals(other.sideTwo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Triangle [sideOne=" + sideOne + ", sideTwo=" + sideTwo
				+ ", sideThree=" + sideThree + ", triangleType=" + triangleType
				+ "]";
	}

}
