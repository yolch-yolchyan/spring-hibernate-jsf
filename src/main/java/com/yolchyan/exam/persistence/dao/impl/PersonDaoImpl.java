/**
 * 
 */
package com.yolchyan.exam.persistence.dao.impl;

import com.yolchyan.exam.persistence.dao.PersonDao;
import com.yolchyan.exam.persistence.domain.Person;
import com.yolchyan.exam.persistence.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 * this class for persons in dao layer
 *
 * <p>
 * this class extends of ({@link GenericDaoImpl} and implements of {@link PersonDao}
 *
 * @author Artur Yolchyan
 * @see GenericDaoImpl
 * @see PersonDao
 */
@Repository("personDao")
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

    /**
     * @see PersonDao#loadRoles()
     */
    @Override
    public List<Role> loadRoles() {
        return sessionFactory.getCurrentSession().createQuery("FROM Role r").list();
    }
}