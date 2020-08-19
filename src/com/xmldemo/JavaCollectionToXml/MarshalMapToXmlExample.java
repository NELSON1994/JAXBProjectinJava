package com.xmldemo.JavaCollectionToXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.HashMap;


public class MarshalMapToXmlExample {
    public void marshalMapToXml() throws JAXBException {
        HashMap<Integer,Employee> map=new HashMap<Integer,Employee>();
        Employee employee1=new Employee(1,"Nelson","Moses",6900.00);
        Employee employee2=new Employee(2,"Shirleen","Okeyo",23500.00);
        Employee employee3=new Employee(3,"Tracy","Anne",687800.00);
        Employee employee4=new Employee(4,"Maurine","Ligaye",989700.00);
        Employee employee5=new Employee(5,"LMFKFKFKF","Vic",100900.00);
        Employee employee6=new Employee(6,"QASDFGGF","Avm",9303450.00);
        map.put(1,employee1);map.put(2,employee2);map.put(3,employee3);
        map.put(4,employee4);map.put(5,employee5);map.put(6,employee6);

        //add employees in the map
        EmployeeMap employeeMap=new EmployeeMap();
        employeeMap.setEmployeeMap(map);

        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(employeeMap, System.out);
        File file= new File("file/mapemployees.xml");
        jaxbMarshaller.marshal(employeeMap,file);

    }
}
