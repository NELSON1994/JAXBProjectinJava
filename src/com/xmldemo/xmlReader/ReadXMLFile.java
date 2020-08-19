package com.xmldemo.xmlReader;

import com.xmldemo.models.Student;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * @Aurthor: Nelson
 */
public class ReadXMLFile {
    public void readXml() {
        try {
            Student student = new Student();
            File file = new File("file/input.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("~~~~~~~~~~ROOT ELEMENT~~~~~~~~" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("student");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~SEPARATOR~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("~~~~~~~~~~~~~~~~~~NODE NAME~~~~~~~~~~~~~~~~" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String firstname;
                    String rollNumber;
                    String lastname;
                    String nickname;
                    String marks;
                    rollNumber = element.getAttribute("rollno");
                    firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
                    nickname = element.getElementsByTagName("nickname").item(0).getTextContent();
                    marks = element.getElementsByTagName("marks").item(0).getTextContent();

                    student.setFirstname(firstname);
                    student.setId(String.valueOf(temp));
                    student.setLastname(lastname);
                    student.setNickname(nickname);
                    student.setMarks(Integer.parseInt(marks));
                    System.out.println("~~~~~~~~~~~~~~~  ROLL NUMBER  ~~~~~~~~~~~~~~~~~~~~~~~~~~" + rollNumber);
                    System.out.println("~~~~~~~~~~~~~~~  FIRST NAME  ~~~~~~~~~~~~~~~~~~~~~~~~~~" + student.getFirstname());
                    System.out.println("~~~~~~~~~~~~~~~  LAST NAME  ~~~~~~~~~~~~~~~~~~~~~~~~~~" + student.getLastname());
                    System.out.println("~~~~~~~~~~~~~~~  NICK NAME  ~~~~~~~~~~~~~~~~~~~~~~~~~~" + student.getNickname());
                    System.out.println("~~~~~~~~~~~~~~~  MARKS  ~~~~~~~~~~~~~~~~~~~~~~~~~~" + student.getMarks());

                    System.out.println("~~~~~~~~~~~~~~~ {{{{END *****************************END }}}}}~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void queryXml() {
        try {
            Student student = new Student();
            File file = new File("file/input2.txt");
            DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory1.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("~~~~~~~~~~ROOT ELEMENT~~~~~~~~" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("supercars");
            NodeList nodeList2 = doc.getElementsByTagName("luxurycars");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~SEPARATOR~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("~~~~~~~~~~~~~~~~~~NODE NAME~~~~~~~~~~~~~~~~" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String at = element.getAttribute("company");
                    System.out.println("~~~~~~~~~~~~ÑAME~~~~~~~~~~~~~~~~~~" + at);
                    NodeList cars = element.getElementsByTagName("carname");
//                    for (int i=0; i<cars.getLength();i++){
//                        Element c=(Element) cars;
//                        String make;
//                        String type;
//                        type=c.getAttribute("type");
//                        make=c.getElementsByTagName("carname").item(0).getTextContent();
//
//
//                        System.out.println("******************TYPE******************"+type);
//                        System.out.println("******************Make******************"+make);
//                    }
                }
            }

            for (int temp1 = 0; temp1 < nodeList.getLength(); temp1++) {
                Node node2 = nodeList2.item(temp1);
                System.out.println("~~~~~~~~~~~~~~~~~~NODE NAME~~~~~~~~~~~~~~~~" + node2.getNodeName());
                if (node2.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node2;
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createXMLFile() {
        /**
         *
         * <?xml version = "1.0" encoding = "UTF-8" standalone = "no"?>
         * <cars>
         *    <supercars company = "Ferrari">
         *       <carname type = "formula one">Ferrari 101</carname>
         *       <carname type = "sports">Ferrari 202</carname>
         *    </supercars>
         * </cars>
         *
         */
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // create root element====<cars>
            Element element=doc.createElement("cars");
            doc.appendChild(element);

            // supercars elements
            Element element2=doc.createElement("supercars");
            element.appendChild(element2);

            //setting attribute to element
            Attr attr=doc.createAttribute("company");
            attr.setValue("Ferrari");
            element2.setAttributeNode(attr);
            //car name element
            Element carname=doc.createElement("carname");
            Attr attrType=doc.createAttribute("type");
            attrType.setValue("formula one");
            carname.setAttributeNode(attrType);
            carname.appendChild(doc.createTextNode("Ferrari 101"));
            element2.appendChild(carname);

            Element carname1=doc.createElement("carname");
            Attr attrType1=doc.createAttribute("type");
            attrType.setValue("formula one");
            carname1.setAttributeNode(attrType1);
            carname1.appendChild(doc.createTextNode("Ferrari 202"));
            element2.appendChild(carname1);


            //write the content to XML FILE
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
            DOMSource domSource=new DOMSource(doc);
            File file=new File("file/new.xml");
            StreamResult streamResult=new StreamResult(file);

            //output for console for testing
            StreamResult streamResult1=new StreamResult(System.out);
            transformer.transform(domSource,streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
