/**
 * 
 */
package com.yolchyan.exam.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.yolchyan.exam.persistence.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yolchyan.exam.front.bean.PersonBean;
import com.yolchyan.exam.persistence.dao.PersonDao;
import com.yolchyan.exam.persistence.domain.Person;
import com.yolchyan.exam.persistence.service.PersonService;

/**
 * <p>
 * this class implements from interface PersonService
 * 
 * @see PersonService
 * @author Artur Yolchyan
 */
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
	
	private PersonDao personDao;

	
	/**
	 * @see PersonService#createOrUpdate(PersonBean)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public Long createOrUpdate(PersonBean personBean) {
		Person person = initPersonByPersonBean(personBean);
		return personDao.createOrUpdate(person).getId();
	}

	/**
	 * @see PersonService#delete(Long)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void delete(Long id) {
		personDao.delete(personDao.getById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see com.yolchyan.exam.persistence.service.PersonService#getById(java.lang.Long)
	 */
	@Override
	public PersonBean getById(Long id) {
		Person person = personDao.getById(id);
		return initPersonBeanByPerson(person, true);
	}
	
	/**
	 * @see PersonService#getPersons(boolean)
	 */
	@Override
	public List<PersonBean> getPersons(boolean eagerLoad) {
		List<Person> persons = personDao.loadAll();
		return initPersonBeanListByPersonList(persons, eagerLoad);
	}
	
	/**
	 * @see PersonService#getRoleItems()
	 */
	@Override
	public List<SelectItem> getRoleItems() {
		List<Role> roles = personDao.loadRoles();
		
		final List<SelectItem> items = new ArrayList<>();
		roles.forEach(v -> items.add(new SelectItem(v.getId(), v.getName())));
		
		return items;
	}

	/**
	 * initialize {@link Person} by {@link PersonBean}
	 * 
	 * @param personBean - PersonBean
	 * @return - Person
	 */
	private Person initPersonByPersonBean(PersonBean personBean) {
		Person person = new Person();
		person.setId(personBean.getId());
		person.setFirstName(personBean.getFirstName());
		person.setLastName(personBean.getLastName());

		person.setRole(new Role());
		person.getRole().setId(personBean.getRoleId());

		return person;
	}
	
	/**
	 * initialize {@link Person} by {@link PersonBean}
	 * 
	 * @param person - PersonBean
	 * @param eagerLoad - boolean
	 * @return - Person
	 */
	private PersonBean initPersonBeanByPerson(Person person, boolean eagerLoad) {
		PersonBean personBean = new PersonBean();
		personBean.setId(person.getId());
		personBean.setFirstName(person.getFirstName());
		personBean.setLastName(person.getLastName());

		/* because role property for Person class annotated with fetch type lazy
		   if eagerLoad false it won't load role items during select process */
		if (eagerLoad) {
			personBean.setRoleId(person.getRole().getId());
			personBean.setRoleName(person.getRole().getName());
		}

		return personBean;
	}
	
	/**
	 * initialize {@link List} of {@link PersonBean} by {@link List} of {@link Person}
	 * 
	 * @param persons - List
	 * @param eagerLoad - boolean
	 * @return - List
	 */
	private List<PersonBean> initPersonBeanListByPersonList(List<Person> persons, boolean eagerLoad) {
		List<PersonBean> personbBeans = new ArrayList<>();
		persons.forEach(v -> personbBeans.add(initPersonBeanByPerson(v, eagerLoad)));
		return personbBeans;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
