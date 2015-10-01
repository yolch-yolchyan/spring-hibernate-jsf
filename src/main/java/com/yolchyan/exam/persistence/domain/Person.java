/**
 * 
 */
package com.yolchyan.exam.persistence.domain;

import javax.persistence.*;
import java.util.Set;


/**
 * <p>
 * class extends of {@link BaseDomain}
 * </p>
 * 
 * <p>
 * this domain class mapped with table person
 * </p>
 * 
 * @author Artur Yolchyan
 */
@Entity
@Table(name = "person")
@AttributeOverride(column = @Column(name = "person_id", unique = true), name = "id")
public class Person extends BaseDomain {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 2908149550976965409L;
	
	
	private String firstName;
	
	private String lastName;

	private Role role;
	

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
