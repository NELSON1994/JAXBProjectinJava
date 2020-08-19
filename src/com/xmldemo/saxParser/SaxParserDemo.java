package com.xmldemo.saxParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParserDemo {
    public void saxMethod(){
    try{
        File inputFile= new File("file/input.txt");
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser=saxParserFactory.newSAXParser();
        UserHandler userHandler=new UserHandler();
        saxParser.parse(inputFile,userHandler);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    }
}
