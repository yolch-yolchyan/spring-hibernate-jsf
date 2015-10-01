/**
 * 
 */
package com.yolchyan.exam.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * <p>
 * this base class base for domains
 * 
 * @author Artur Yolchyan
 * @version 1.0
 */
@MappedSuperclass
public class BaseDomain implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 7405177016888528737L;
	
	
	protected Long id;	
	

	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		BaseDomain obj1 = null;
		if (obj instanceof BaseDomain) {
			obj1 = (BaseDomain) obj;
		} else {
			return super.equals(obj);
		}
		return this.id == obj1.id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (this.id != null) {
			return id.intValue();
		}
		return super.hashCode();
	}
	
}
