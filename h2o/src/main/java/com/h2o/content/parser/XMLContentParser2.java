package com.h2o.content.parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
//https://howtodoinjava.com/jaxb/jaxb-unmarshaller-example/
public class XMLContentParser2 {
	public static void main(String[] args)
    {

		String fileName = "data/reuters/sgm/reut2-000.xml";
 
        jaxbXmlFileToObject(fileName);
    }
 
    private static void jaxbXmlFileToObject(String fileName) {
         
        File xmlFile = new File(fileName);
         
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Reuters.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Reuters e = (Reuters) jaxbUnmarshaller.unmarshal(xmlFile);
        	StringBuffer b = new StringBuffer();
        	LuceneWriteIndex.index(e);
            System.out.println(e);
        	
            
        }
        catch (JAXBException je)
        {
            je.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }        
    }
}
