/**
 * 
 */
package com.yolchyan.exam.persistence.dao;

import java.util.List;

/**
 * <p>
 * this interface base for all dao interfaces and interface
 * has methods which generic for all backend
 * </p>
 * 
 * <p>
 * interface contain static variables for SQL and HQL(Hibernate Query Language) queries
 * </p>
 * 
 * @author Artur Yolchyan
 */
public interface GenericDao<T> {

	/**
	 * created or updated from db by entity
	 * 
	 * @param entity - T
	 */
	T createOrUpdate(T entity);
	
	/**
	 * deleted from db by entity
	 * 
	 * @param entity - T
	 */
	void delete(T entity);

	/**
	 * This method load by generic type all data
	 *
	 * @return - List of entities
	 */
	List<T> loadAll();

	/**
	 * Thie method load entity by their id
	 *
	 * @param id - Long
	 * @return - T - generic type for current dao class
	 */
	T getById(Long id);
	
}
