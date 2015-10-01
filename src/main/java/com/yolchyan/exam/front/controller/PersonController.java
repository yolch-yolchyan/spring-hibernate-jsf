/**
 * 
 */
package com.yolchyan.exam.front.controller;

import com.yolchyan.exam.front.bean.PersonBean;
import com.yolchyan.exam.persistence.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * this controller for persons
 *
 * <p>
 * this is not good idea to declare controllers in session scope,
 * but for this simple application we have a single controller and
 * it is good to have session scope(from xml) for this controller, if we will
 * have more than one page and controller we should implement jsf spring
 * view scope and declare all controllers in view scope
 *
 * for view scope please visit @link{http://forum.spring.io/forum/spring-projects/web/72898-view-scope-with-spring}
 * 
 * @author Artur Yolchyan
 * @version 1.0
 */
public class PersonController implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -3732464264031717727L;

	
	private transient PersonService personService;
	
	
	private PersonBean personBean;
	
	private List<PersonBean> persons;
	
	private List<SelectItem> roles;
	
	
	/**
	 * this method called when opened person management page
	 */
	public void init() {
		personBean = new PersonBean();
		// this property always false for loading persons, it just for presentation how could we store lazy load
		persons = personService.getPersons(false);
		roles = personService.getRoleItems();
	}

	/**
	 *
	 * @param actionEvent - ActionEvent
	 */
	public void onCreateOrUpdate(ActionEvent actionEvent) {
		personService.createOrUpdate(personBean);
		persons = personService.getPersons(false);
		personBean = new PersonBean();
	}
	
	/**
	 * deleted person
	 * 
	 * @param deleteBean - PersonBean
	 */
	public void onDelete(PersonBean deleteBean) {
		personService.delete(deleteBean.getId());
		persons = personService.getPersons(false);
	}
	
	/**
	 * edited person
	 * 
	 * @param personBean - PersonBean
	 */
	public void onEdit(PersonBean personBean) {
		this.personBean = personService.getById(personBean.getId());
	}
	
	/**
	 * resets all fields
	 * 
	 * @param actionEvent - ActionEvent
	 */
	public void onReset(ActionEvent actionEvent) {
		if (personBean.getId() == null) {
			personBean = new PersonBean();
		} else {
			personBean = personService.getById(personBean.getId());
		}
	}

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public List<PersonBean> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonBean> persons) {
		this.persons = persons;
	}

	public List<SelectItem> getRoles() {
		return roles;
	}

	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}
