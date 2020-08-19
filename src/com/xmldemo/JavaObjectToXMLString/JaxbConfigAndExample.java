package com.xmldemo.JavaObjectToXMLString;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

/*
@Author: NELSON
@Date:17:AUG:2020
 */

public class JaxbConfigAndExample {
    public String jaxbConfigurationsExample() {
        StringWriter stringWriter = new StringWriter();
        try {
            /*
            To convert a Java object to an XML string, you need to first create an instance of JAXBContext.
            This is the entry point to JAXB API that provides several methods to marshal, unmarshal, and validate XML documents.
             */
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);

            // JAXBContext jaxbContext=JAXBContext.newInstance()// when we have many classes to parse on jaxbContext

            // create an instance of `Marshaller`
            Marshaller marshaller = jaxbContext.createMarshaller();

            //enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // write xml to StringWriter
            stringWriter = new StringWriter();

            //create instance of book
            Author author = new Author(5L, "Bert", "Bates");
            Book book = new Book(17L, "Head First Java", "ISBN-45565-45");

            //convert book to xml
            marshaller.marshal(book, stringWriter);
            System.out.println("~~~~~~~~~~~~~~~~~~~~OUTPUT XML~~~~~~~~~~~~~~" + stringWriter.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
    public void saveXMLToFile(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //create xml file
            File file =new File("file/books.xml");
            // create instance of the book
            Book book = new Book(17L, "Head First Java", "ISBN-45565-45");
            //convert book object to xml file
            marshaller.marshal(book,file);


            //read the content of the generated xml file

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
