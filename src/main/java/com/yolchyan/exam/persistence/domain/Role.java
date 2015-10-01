package com.yolchyan.exam.persistence.domain;

import javax.persistence.*;

/**
 * <p>
 * class extends of {@link BaseDomain}
 * </p>
 *
 * <p>
 * this domain class mapped with table role
 * </p>
 *
 * @author Artur Yolchyan
 */
@Entity
@Table(name = "role")
@AttributeOverride(column = @Column(name = "role_id", unique = true), name = "id")
public class Role extends BaseDomain {

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = 4703564720880209348L;


    private String name;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
