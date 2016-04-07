package com.walmart.delivery.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

/**
 * City entity
 *  
 * @author josemanzoli
 * 
 */
@NodeEntity
public class City extends AbstractEntity {
	
	@Indexed
	private String name;
	
	private String state;
		
	
	@Fetch @RelatedToVia(type = "DISTANCE",direction=Direction.BOTH)
    private Set<Path> citiesThatHavePaths;
	
	public City(){
		
	}
	
	public City(String name, String state){
		this.name = name;
		this.state = state;
		this.citiesThatHavePaths = new HashSet<Path>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Path> getCitiesThatHavePaths() {
		return citiesThatHavePaths;
	}

	public void setCitiesThatHavePaths(Set<Path> citiesThatHavePaths) {
		this.citiesThatHavePaths = citiesThatHavePaths;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + " paths="+citiesThatHavePaths.size() + "]";
	}
}