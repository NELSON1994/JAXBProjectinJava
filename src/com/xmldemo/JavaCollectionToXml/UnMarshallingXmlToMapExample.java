package com.xmldemo.JavaCollectionToXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnMarshallingXmlToMapExample {
public void unmarshallingg(){
    JAXBContext jaxbContext = null;
    try {
        jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file=new File("file/mapemployees.xml");

        EmployeeMap employeeMap=(EmployeeMap)unmarshaller.unmarshal(file);
        //looping using the KEY
        for (Integer empId:employeeMap.getEmployeeMap().keySet()){
            System.out.println("~~~~~~DETAILS~~~~");
            System.out.println(employeeMap.getEmployeeMap().get(empId).getFirstName()+
                    "\n"+employeeMap.getEmployeeMap().get(empId).getLastName()+"\n"+
                    employeeMap.getEmployeeMap().get(empId).getIncome());
        }

        System.out.println("@#$%^&*())))))))))))))))))))********************************************************************");
        //LOOPING USING THE VALUE
        for (Employee employee:employeeMap.getEmployeeMap().values()){
            System.out.println("~~~~~~DETAILS~~~~");
            System.out.println(employee.getFirstName()+"\n"+employee.getLastName()+"\n"+employee.getIncome());
        }

    } catch (JAXBException e) {
        e.printStackTrace();
    }

}

}
