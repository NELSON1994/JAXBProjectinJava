package com.xmldemo.JavaObjectToXMLString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/*
*@Author: NELSON
 **/

//we will create the Book class and annotate its fields with JAXB annotations to control how it should be marshalled to XML:
@XmlRootElement(name = "book")
public class Book {
    private Long id;
    private String title;
    private String isbn;
   // private Author author;

    public Book() {
    }

    public Book(Long id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
      //  this.author = author;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlAttribute(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    @XmlAttribute(name = "isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    public Author getAuthor() {
//        return author;
//    }
//
//    @XmlAttribute(name = "author")
//    public void setAuthor(Author author) {
//        this.author = author;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
              //  ", author=" + author +
                '}';
    }
}

/*
@XmlRootElement — This annotation is used at the top-level class to specify the root element of the XML document.
 The name attribute in the annotation is optional.
If not specified, the class name is used as the name of the root element in the XML document.
=======================================================================================================
@XmlAttribute — This annotation is used to indicate the attribute of the root element.
======================================================================================================
@XmlElement — This annotation is used on the fields of the class that will be the sub-elements of the root element.

 The Book class is now ready to be marshaled into an XML document.
 */
