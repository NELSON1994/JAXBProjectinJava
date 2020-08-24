package com.xmldemo.JavaCollectionToXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MarshalListToXmlEmployees {

    public StringWriter marshalling() throws JAXBException, IOException, SAXException, ParserConfigurationException {

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

        EmployeeReadingFromResponse employeeReadingFromResponse=new EmployeeReadingFromResponse();
        List<EmployeeReadingFromResponse> list=new ArrayList<>();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("~~~~~~~~~~ROOT ELEMENT~~~~~~~~" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("employee");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~SEPARATOR~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                //System.out.println("~~~~~~~~~~~~~~~~~~NODE NAME~~~~~~~~~~~~~~~~" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String fname,lname;
                    int id;double income;

                    id= Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    fname=element.getElementsByTagName("firstName").item(0).getTextContent();
                    lname=element.getElementsByTagName("lastName").item(0).getTextContent();
                    income= Double.parseDouble(element.getElementsByTagName("income").item(0).getTextContent());

                    employeeReadingFromResponse.setFirstName(fname);
                    employeeReadingFromResponse.setId(id);
                    employeeReadingFromResponse.setLastName(lname);
                    employeeReadingFromResponse.setIncome(income);

                }

                //save the employeeeeee to db


                //add the employee to list
                list.add(employeeReadingFromResponse);


            }
        System.out.println("==================================================================================");
        System.out.println("~~~~~~~~~~~~~~LIST OF EMPLOYEESSSS\n"+list);
        System.out.println("==================================================================================");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for(EmployeeReadingFromResponse e:list){

                System.out.println("~~~~~~~~~~~~~~EMPLOYEE DETAILS~~\n"+"ID~~~~: " +e.getId()+"\n FIRSTNAME~~~~: "+e.getFirstName()+"\n LASTNAME~~~~: "+e.getLastName()+"\n INCOME~~~~~: "+e.getIncome());
            }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //marshall the list to stringWriter
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(employees,stringWriter);
        String response=stringWriter.toString();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~ÕUT PUT IN STRING~~~~~~~~~~~~~~~~~~~~~~~~"+response);

        return stringWriter;


    }

    public void readingStringWriterToJavaObject() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        StringWriter stringWriter1= new StringWriter();
        EmployeeReadingFromResponse employeeReadingFromResponse=new EmployeeReadingFromResponse();
        List<EmployeeReadingFromResponse> list=new ArrayList<>();
        stringWriter1=marshalling();

        JAXBContext context=JAXBContext.newInstance(ListOfEmployees.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~STRINGWRITER RESPONSE~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+stringWriter1.toString());
        StringReader reader=new StringReader(stringWriter1.toString());
        ListOfEmployees listOfEmployees=(ListOfEmployees)unmarshaller.unmarshal(reader);// unmarshalling to List of employee class
        List<EmployeeReadingFromResponse> list1=listOfEmployees.getEmployees();

        System.out.println(">>>^^^^^^^^^^^^>=======UNMARSHALING STRINGWRITER RESPONSE TO JAVA CLASS======>>>^^^^^^^^^^>>>>>>>>>>>>>>>>");

        for(EmployeeReadingFromResponse e:list1){

            System.out.println("~~~~~~~~~~~~~~EMPLOYEE DETAILS~~\n"+" ID~~~~: " +e.getId()+"\n FIRSTNAME~~~~: "+e.getFirstName()+"\n LASTNAME~~~~: "+e.getLastName()+"\n INCOME~~~~~: "+e.getIncome());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


    }


}
