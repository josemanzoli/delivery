package com.manzoli.delivery.domain;

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * Abstract entity for all entities of this model
 * Used to implements an Id
 *  
 * @author josemanzoli
 * 
 */
public abstract class AbstractEntity {

	@GraphId
	private Long id;

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
