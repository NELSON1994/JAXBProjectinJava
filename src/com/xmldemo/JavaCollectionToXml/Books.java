package com.xmldemo.JavaCollectionToXml;

import com.xmldemo.JavaObjectToXMLString.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "books")
public class Books {
    private List<Book> books;

    public List<Book> getBook() {
        return books;
    }
    @XmlElement(name = "book")
    public void setBook(List<Book> books) {
        this.books = books;
    }

    public void add(Book book) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        this.books.add(book);
    }
}
