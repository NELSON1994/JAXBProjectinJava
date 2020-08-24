package com.xmldemo.JavaCollectionToXml;

public class EmployeeReadingFromResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private double income;

    public EmployeeReadingFromResponse() {
    }

    public EmployeeReadingFromResponse(Integer id, String firstName, String lastName, double income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
