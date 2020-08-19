package com.xmldemo.JavaCollectionToXml;

import com.xmldemo.XMLToJavaObject.Course;
import com.xmldemo.XMLToJavaObject.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/*
@Aurthor:NELSON Moses
@Date:
 */

public class UnMarshalXMLToListEmployees {

    public void unMarshall() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);

            //NOTE=====> We use UNMARSHALLER
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //file where it was found
            File file = new File("file/employees.xml");

            Employees employees = (Employees) unmarshaller.unmarshal(file);

            //loop on the list of employees
            for (Employee employee : employees.getEmployees()) {
                String fname = employee.getFirstName();
                String lname = employee.getLastName();
                Double income = employee.getIncome();
                System.out.println("First Name : " + fname + ">>>>Last Name : " + lname + " >>>>Income : " + income);
                System.out.println("~~~~~~~~~~~~~~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~~~~~");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public void unMarshalUrl() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //using url

            /*
            <course>
                    <id>1</id>
                    <title>Introduction to Spring Boot & Thymeleaf</title>
                    <price>49.99</price>
                    <created>2019-03-15</created>
                    <student>
                        <id>1</id>
                        <first_name>George</first_name>
                        <last_name>Bluth</last_name>
                        <avatar>https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg</avatar>
                    </student>
                    <student>
                        <id>2</id>
                        <first_name>Janet</first_name>
                        <last_name>Weaver</last_name>
                        <avatar>https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg</avatar>
                    </student>
                    <student>
                        <id>3</id>
                        <first_name>Emma</first_name>
                        <last_name>Wong</last_name>
                        <avatar>https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg</avatar>
                    </student>
            </course>
             */
            String url = "http://www.mocky.io/v2/5c8bdd5c360000cd198f831e";
            URL url1 = new URL(url);

            Course course = (Course) unmarshaller.unmarshal(url1);
            List<Student> listOfStudent = course.getStudents();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~COURSE DETAILS~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("TITLE : " + course.getTitle() + "\n" + "CREATION DATE : " + course.getCreated() + "\n" + "COURSE PRICE : " + course.getPrice());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~STUDENTS IN THE COURSE>>>>>>" + course.getTitle());
            for (Student student : listOfStudent) {
                System.out.println("~~~~~~~~~Student info~~~~~~~~");
                System.out.println("FIRST NAME : " + student.getFirst_name() + "\n" + "LAST NAME : " + student.getLast_name());
                System.out.println("~~~~~~~~~~~~~~~~~~end of student details~~~~~~~~~~~~~~~~~~");
            }

        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
