package com.xmldemo.JavaCollectionToXml;

import com.xmldemo.JavaObjectToXMLString.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JavaCollectionToXmlExample {

    public void convert() {
        // create an instance of `JAXBContext`
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Books.class);
            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // create `Books` object
            Books books = new Books();

            // add books to list
            books.add(new Book(1L, "Head First Java", "ISBN-45565-45"));
            books.add(new Book(2L, "Thinking in Java", "ISBN-95855-3"));

            // convert `Books` object to XML file
            marshaller.marshal(books, new File("file/bookss.xml"));

            marshaller.marshal(books, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
