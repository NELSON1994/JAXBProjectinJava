package com.xmldemo.saxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
@Author: NELSON
@Date:17:AUG:2020
 */
public class UserHandler extends DefaultHandler {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      //  super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("student")){
            String rollNo=attributes.getValue("rollno");

        }
        else if(qName.equalsIgnoreCase("firstname")){
            String fname=attributes.getValue("firstname");
            bFirstName=true;

        }
        else if(qName.equalsIgnoreCase("lastname")){
            String lname=attributes.getValue("lastname");
            bFirstName=true;
        }
        else if(qName.equalsIgnoreCase("nickname")){
            String nname=attributes.getValue("nickname");
            bNickName=true;
        }
        else if(qName.equalsIgnoreCase("marks")){
            String marks=attributes.getValue("marks");
            bMarks=true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //super.endElement(uri, localName, qName);

        //System.out.println("~~~~~~~~~~~~~~~~~~~~~`End of student~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       // super.characters(ch, start, length);
        if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bNickName) {
            System.out.println("Nick Name: " + new String(ch, start, length));
            bNickName = false;
        } else if (bMarks) {
            System.out.println("Marks: " + new String(ch, start, length));
            bMarks = false;
        }
    }
}
