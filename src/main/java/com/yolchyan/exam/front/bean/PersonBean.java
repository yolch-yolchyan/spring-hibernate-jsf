/**
 * 
 */
package com.yolchyan.exam.front.bean;

import java.io.Serializable;


/**
 * <p>
 * this class implements from interface {@link Serializable}
 * 
 * <p>
 * this class contain properties for working person info in frontend
 * 
 * @author Artur Yolchyan
 * @version 1.0
 */
public class PersonBean implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 4754000697133447073L;


	private Long id;
	
	private String firstName;
	
	private String lastName;

	// we could have other bean class for role, but for this simple app this is the best solution
	private Long roleId;

	private String roleName;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
