package com.xmldemo.GenerateXSDfromJAXBClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/*
GO TO >>>Tools>>>>JAXB>>>>Generate XMLschema from JAVA Using JAXB

 */
@XmlRootElement(name = "schoolprincipal")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PrincipalOfSchool implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;

    public PrincipalOfSchool() {
    }

    public PrincipalOfSchool(Integer id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
