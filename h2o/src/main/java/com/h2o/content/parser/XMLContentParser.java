package com.h2o.content.parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLContentParser {
	public static void main(String[] args){

		String fileName = "data/reuters/sgm/employee.xml";
 
        jaxbXmlFileToObject(fileName);
    }
 
    private static void jaxbXmlFileToObject(String fileName) {
         
        File xmlFile = new File(fileName);
         
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
        	
            System.out.println(employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
