package com.manzoli.delivery.service.impl;

import org.springframework.stereotype.Service;

import com.manzoli.delivery.domain.Triangle;
import com.manzoli.delivery.enumerate.TriangleType;

/**
 * Service used to validate the triangle conditions 
 *  
 * @author josemanzoli
 * 
 */
@Service
public class TriangleServiceImpl {
	
	/**
	 * General method to classify a triangle
	 * 
	 * @param triangle
	 * @return TriangleType
	 * @see Triangle
	 * @see TriangleType
	 */
	public TriangleType classify(Triangle triangle){
		
		if (cantBeAnyTriangleType(triangle)){
			return TriangleType.INVALID;
		}
		
		if (isEquilateral(triangle)){
			return TriangleType.EQUILATERAL;
		}
		
		if (isScalene(triangle)){
			return TriangleType.SCALENE;
		}
		
		if (isIsosceles(triangle)){
			return TriangleType.ISOSCELES;
		}

		//if the triangle wasn't able to pass for any condition above, then it is an invalid triangle for sure
		return TriangleType.INVALID;
	}

	/**
	 * Inequality triangle validation
	 * An inequality triangle is a a triangle that the sum of the lengths of any two sides must be greater than or equal 
	 * to the length of the remaining side.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private boolean cantBeAnyTriangleType(Triangle triangle) {
		
		boolean sideOneValidation = triangle.getSideOne() > triangle.getSideTwo() + triangle.getSideThree();
		boolean sideTwoValidation = triangle.getSideTwo() > triangle.getSideOne() + triangle.getSideThree();
		boolean sideThreeValidation = triangle.getSideThree() > triangle.getSideTwo() + triangle.getSideOne();
		boolean zeroValidation = triangle.getSideOne().equals(0) || triangle.getSideTwo().equals(0) || triangle.getSideThree().equals(0);
		
		return sideOneValidation || sideTwoValidation || sideThreeValidation || zeroValidation;
	}
	
	/**
	 * Equilateral triangle validation
	 * An equilateral triangle is a triangle in which all three sides are equal.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private boolean isEquilateral(Triangle triangle) {
		return triangle.getSideOne().equals(triangle.getSideTwo()) && triangle.getSideTwo().equals(triangle.getSideThree());
	}

	/**
	 * Scalene triangle validation
	 * A scalene triangle is a triangle that has three unequal sides
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private boolean isScalene(Triangle triangle) {
		
		boolean sideOneValidation = !triangle.getSideOne().equals(triangle.getSideTwo());
		boolean sideTwoValidation = !triangle.getSideTwo().equals(triangle.getSideThree());
		boolean sideThreeValidation = !triangle.getSideThree().equals(triangle.getSideOne());
		
		return sideOneValidation && sideTwoValidation && sideThreeValidation; 
	}
	
	/**
	 * Isosceles triangle validation
	 * An isosceles triangle is a triangle with (at least) two equal sides.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private boolean isIsosceles(Triangle triangle) {
		
		boolean sideOneValidation = triangle.getSideOne().equals(triangle.getSideTwo());
		boolean sideTwoValidation = triangle.getSideTwo().equals(triangle.getSideThree());
		boolean sideThreeValidation = triangle.getSideThree().equals(triangle.getSideOne());
		
		return sideOneValidation || sideTwoValidation || sideThreeValidation;
	}	
}
