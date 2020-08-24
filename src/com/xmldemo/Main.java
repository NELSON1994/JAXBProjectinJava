package com.xmldemo;

import com.xmldemo.JavaCollectionToXml.*;
import com.xmldemo.JavaObjectToXMLString.JaxbConfigAndExample;
import com.xmldemo.XMLStringToJavaObject.XmlToJavaObject;
import com.xmldemo.XMLToJavaObject.Course;
import com.xmldemo.XMLToJavaObject.XMLService;
import com.xmldemo.saxParser.SaxParserDemo;
import com.xmldemo.xmlReader.ReadXMLFile;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException {
	// write your code here
        ReadXMLFile readXMLFile= new ReadXMLFile();
       // readXMLFile.readXml();
       //readXMLFile.queryXml();
       // readXMLFile.createXMLFile();

       // SaxParserDemo saxParserDemo= new SaxParserDemo();
       // saxParserDemo.saxMethod();


        // conversion
        JaxbConfigAndExample jj=new JaxbConfigAndExample();
       // jj.jaxbConfigurationsExample();
        //jj.saveXMLToFile();

        XmlToJavaObject xmlToJavaObject=new XmlToJavaObject();
       // xmlToJavaObject.xmltoJavaExample();

        JavaCollectionToXmlExample javaCollectionToXmlExample=new JavaCollectionToXmlExample();
       // javaCollectionToXmlExample.convert();



        //reading xml response from response
        XMLService xmlService=new XMLService();
//        Course c=xmlService.parseCourse();
//        System.out.println(c.getCreated());
//        System.out.println(c.getId());
//        System.out.println(c.getPrice());
//        System.out.println(c.getStudents());
//        System.out.println(c.getTitle());

        MarshalListToXmlEmployees marshalListToXmlEmployees=new MarshalListToXmlEmployees();
       // marshalListToXmlEmployees.marshalling();
        marshalListToXmlEmployees.readingStringWriterToJavaObject();

        UnMarshalXMLToListEmployees unMarshalXMLToListEmployees=new UnMarshalXMLToListEmployees();
       // unMarshalXMLToListEmployees.unMarshall();
       // unMarshalXMLToListEmployees.unMarshalUrl();

        MarshalMapToXmlExample marshalMapToXmlExample=new MarshalMapToXmlExample();
       // marshalMapToXmlExample.marshalMapToXml();

        UnMarshallingXmlToMapExample unMarshallingXmlToMapExample=new UnMarshallingXmlToMapExample();
       // unMarshallingXmlToMapExample.unmarshallingg();

    }


}
