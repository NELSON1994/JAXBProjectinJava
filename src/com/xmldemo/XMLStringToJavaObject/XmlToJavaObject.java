package com.xmldemo.XMLStringToJavaObject;


import com.xmldemo.JavaObjectToXMLString.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/*
UNMARSHALLING
 */
public class XmlToJavaObject {
    public void xmltoJavaExample(){
        // create an instance of `JAXBContext`
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // XML file path
            File file = new File("file/books.xml");

            // convert xml file to Book object
            Book book= (Book) unmarshaller.unmarshal(file);

            System.out.println("~~~~~~~~~~~~~~ÕUTPUT~~~~~~~~~~~~~~~~~~~~~~``"+book);


        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
