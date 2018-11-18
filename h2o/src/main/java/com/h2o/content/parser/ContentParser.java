package com.h2o.content.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.xml.XMLParser;
import org.apache.tika.sax.BodyContentHandler;
//https://www.tutorialspoint.com/tika/tika_extracting_xml_document.htm
import org.xml.sax.SAXException;

public class ContentParser {

   public static void main(final String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler(-1);
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File("C:\\Users\\rusye\\git\\h2o\\h2o\\data\\reuters\\sgm\\reut2-000.xml"));
      ParseContext pcontext = new ParseContext();
      
      //Xml parser
      XMLParser xmlparser = new XMLParser(); 
      xmlparser.parse(inputstream, handler, metadata, pcontext);
      System.out.println("Contents of the document:" + handler.toString());
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
         System.out.println(name + ": " + metadata.get(name));
      }
   }
}