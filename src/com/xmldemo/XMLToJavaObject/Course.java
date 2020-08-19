package com.xmldemo.XMLToJavaObject;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
@XmlRootElement(name="course")
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
    private int id;
    private String title;
    private double price;
    private Date created;
    @XmlElement(name="student")
    private List<Student> students;

    public Course() {
    }

    public Course(int id, String title, double price, Date created, List<Student> students) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.created = created;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
