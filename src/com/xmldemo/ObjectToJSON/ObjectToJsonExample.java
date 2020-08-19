package com.xmldemo.ObjectToJSON;

import com.xmldemo.JavaCollectionToXml.Employee;
import com.xmldemo.JavaCollectionToXml.Employees;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectToJsonExample {
    public void objectToJson(){
        Employees employees=new Employees();
        List<Employee> employeeList=new ArrayList<>();
        Employee employee1=new Employee(1,"Nelson","Moses",2900.00);
        Employee employee2=new Employee(2,"Shirleen","Okeyo",9500.00);
        Employee employee3=new Employee(3,"Tracy","Anne",6800.00);
        Employee employee4=new Employee(4,"Maurine","Ligaye",9700.00);
        Employee employee5=new Employee(5,"LMFKFKFKF","Vic",1900.00);
        Employee employee6=new Employee(6,"QASDFGGF","Avm",9300.00);
        employeeList.add(employee1);employeeList.add(employee2);employeeList.add(employee3);
        employeeList.add(employee4);employeeList.add(employee5);employeeList.add(employee6);
        employees.setEmployees(employeeList);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller= jaxbContext.createMarshaller();

            //to format the json
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            //SET JSON TYPE
          //  marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
          //  marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            List<Employee> employee=employees.getEmployees();
            StringWriter sw = new StringWriter();
            marshaller.marshal(employee, sw);
            System.out.println(sw.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }
}
