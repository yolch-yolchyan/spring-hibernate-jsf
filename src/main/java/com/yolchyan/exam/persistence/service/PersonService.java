/**
 * 
 */
package com.yolchyan.exam.persistence.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.yolchyan.exam.front.bean.PersonBean;

/**
 * <p>
 * this service class for person management with dao layer
 *
 * @author Artur Yolchyan
 */
public interface PersonService {
	
	/**
	 * this method create/update person by getting {@link PersonBean}
	 * 
	 * @param personBean - PersonBean
	 * @return - Long
	 */
	Long createOrUpdate(PersonBean personBean);
	
	/**
	 * this method deleted person from db by person id
	 * 
	 * @param id - Long
	 */
	void delete(Long id);
	
	/**
	 * return PersonBean from db by id
	 * 
	 * @param id - Long
	 * @return - PersonBean
	 */
	PersonBean getById(Long id);
	
	/**
	 * return all created persons
	 * 
	 * @return - List
	 */
	List<PersonBean> getPersons(boolean eagerLoad);
	
	/**
	 * return list of SelectItems for role
	 * 
	 * @return - List
	 */
	List<SelectItem> getRoleItems();
	
}
