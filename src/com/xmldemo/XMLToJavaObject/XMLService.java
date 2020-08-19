package com.xmldemo.XMLToJavaObject;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


public class XMLService {

//    private Logger logger= LoggerFactory.getLogger(XMLService.class);

    public Course parseCourse(){
        Course course=new Course();

        try {
            // url that gives the xml response
            String URL = "http://www.mocky.io/v2/5c8bdd5c360000cd198f831e";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            //normalize xml response
            doc.getDocumentElement().normalize();

            //read course details first
            String id=doc.getElementsByTagName("id").item(0).getTextContent();
            String title=doc.getElementsByTagName("title").item(0).getTextContent();
            String price=doc.getElementsByTagName("price").item(0).getTextContent();
            String date=doc.getElementsByTagName("created").item(0).getTextContent();

            int idd=Integer.parseInt(id);
            double pricee=Double.parseDouble(price);
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy");
            //date 31-12-1998
            Date datee=format.parse(date);

            course.setId(idd);
            course.setCreated(datee);
            course.setPrice(pricee);
            course.setTitle(title);

            //Read Student List
            NodeList nodeList=doc.getElementsByTagName("student");

            //create List for student
            List<Student> students=new ArrayList<>();
            Student student=new Student();
            //looping on the student tag on xml
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ÑUMBER of students~~~~~~~~~~~~~~~~"+nodeList.getLength());
            for (int i=0;i<nodeList.getLength();i++){
                System.out.println("~~~~~~~~~~~~~~~~~~~~entered here~~~~~~~~~^^^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                Node node=nodeList.item(i);
                if (node.getNodeType()==Node.ATTRIBUTE_NODE){
                    Element element=(Element) node;
                    //instance of student

                    String iddd=element.getElementsByTagName("id").item(0).getTextContent();
                    String fname=element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lname=element.getElementsByTagName("last_name").item(0).getTextContent();
                    String avatar=element.getElementsByTagName("avatar").item(0).getTextContent();

                    int idv=Integer.parseInt(iddd);
                    student.setAvatar(avatar);
                    student.setId(idv);
                    student.setFirst_name(fname);
                    student.setLast_name(lname);

                    Map<String,Student> sd=new HashMap<>();
                    sd.put("STUDENT DATA", student);
                    System.out.println("~~~~~~~~~~~~~~~~~~~MAP STUDENT DETAILS~~~~~~~~~~~~~~~~~~~~"+sd.toString());

                    students.add(student);
                }

            }
            //set students in a course
            course.setStudents(students);

        }
        catch(Exception e){
            e.printStackTrace();

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~COURSES OUTPUT~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+course);
        return course;
    }
}
