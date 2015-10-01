/**
 * 
 */
package com.yolchyan.exam.persistence.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolchyan.exam.persistence.dao.GenericDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * this class generic for all dao classes and has
 * generic methods
 * 
 * @author Artur Yolchyan
 * @version 1.0
 * @see GenericDao
 */
public class GenericDaoImpl<T> implements GenericDao<T> {
	
	protected SessionFactory sessionFactory;

	private Class<T> entityClass;
	
	/**
	 * @see GenericDao#createOrUpdate(Object)
	 */
	@Override
	public T createOrUpdate(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * @see GenericDao#delete(Object)
	 */
	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * @see GenericDao#loadAll()
	 */
	@Override
	public List<T> loadAll() {
		return sessionFactory.getCurrentSession().createCriteria(getEntityClass()).list();
	}

	/**
	 * @see GenericDao#getById(Long)
	 */
	@Override
	public T getById(Long id) {
		return (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);
	}

	/**
	 * This method return generic instance class, if it not initialized method
	 * initialize it and return
	 *
	 * @return - Class<T>
	 */
	protected Class<T> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
