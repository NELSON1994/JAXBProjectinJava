package com.xmldemo.JavaCollectionToXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MarshalListToXmlEmployees {

    public void marshalling() throws JAXBException {

        Employees employees=new Employees();
        List<Employee> employeeList=new ArrayList<>();
        Employee employee1=new Employee(1,"Nelson","Moses",2900.00);
        Employee employee2=new Employee(2,"Shirleen","Okeyo",9500.00);
        Employee employee3=new Employee(3,"Tracy","Anne",6800.00);
        Employee employee4=new Employee(4,"Maurine","Ligaye",9700.00);
        Employee employee5=new Employee(5,"LMFKFKFKF","Vic",1900.00);
        Employee employee6=new Employee(6,"QASDFGGF","Avm",9300.00);
        Employee employee7=new Employee(7,"TYEIIKEE","SDHBNJM",9900.00);
        Employee employee8=new Employee(8,"SDJDJDJ","YUOIOOJM",9800.00);
        Employee employee9=new Employee(9,"WERSHD","DHSKSK",7900.00);
        Employee employee10=new Employee(10,"YUOKDKD","UNSDMDKS",4900.00);
        Employee employee11=new Employee(11,"XCBNMMM","OKKJK",2900.00);
        employeeList.add(employee1);employeeList.add(employee5);employeeList.add(employee9);
        employeeList.add(employee2);employeeList.add(employee6);employeeList.add(employee10);
        employeeList.add(employee3);employeeList.add(employee7);employeeList.add(employee11);
        employeeList.add(employee4);employeeList.add(employee8);

        employees.setEmployees(employeeList);
//        System.out.println("~~~~~~~~~~~~~~LIST OF EMPLOYEES >>>>>start~~~~~~~~~~~~~~``");
//        for(Employee e:employees.getEmployees()){
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//            System.out.println("~~~~~~~~~~~~First Name~~~~~~~~~~~~~~"+e.getFirstName());
//            System.out.println("~~~~~~~~~~~~Last Name~~~~~~~~~~~~~~"+e.getLastName());
//            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        }

        JAXBContext jaxbContext=JAXBContext.newInstance(Employees.class);
        Marshaller marshaller=jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        //Marshal the employees list in console
        marshaller.marshal(employees,System.out);

        //marshal the list to file
        File file=new File("file/employees.xml");
        marshaller.marshal(employees,file);

        //marshall the list to stringWriter
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(employees,stringWriter);
        String response=stringWriter.toString();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~ÕUT PUT IN STRING~~~~~~~~~~~~~~~~~~~~~~~~"+response);

    }

}
