/**
 * 
 */
package com.yolchyan.exam.persistence.dao;

import com.yolchyan.exam.persistence.domain.Person;
import com.yolchyan.exam.persistence.domain.Role;

import java.util.List;

/**
 * <p>
 * this class extends of {@link GenericDao} and override type T to {@link Person}
 * 
 * @author Artur Yolchyan
 * @version 1.0
 */
public interface PersonDao extends GenericDao<Person> {

    /**
     * This method load person roles,
     *
     * we are not creating role dao, because of role only need this method
     *
     * @return - List of Role
     */
    List<Role> loadRoles();

}
