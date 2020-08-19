package com.xmldemo.GenerateXSDfromJAXBClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class School implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String description;
    private PrincipalOfSchool principal;

    public School() {
    }

    public School(Integer id, String name, String description, PrincipalOfSchool principal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.principal = principal;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PrincipalOfSchool getPrincipal() {
        return principal;
    }

    public void setPrincipal(PrincipalOfSchool principal) {
        this.principal = principal;
    }
}
