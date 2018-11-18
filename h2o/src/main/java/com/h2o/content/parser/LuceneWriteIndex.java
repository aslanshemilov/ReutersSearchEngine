package com.h2o.content.parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public class LuceneWriteIndex 
{
	private static final String INDEX_DIR = "c:/temp/lucene6index";
	
	public static void index(Reuters r) throws Exception{
		IndexWriter writer = createWriter();
		List<Document> documents = new ArrayList<>();
		//Reuters r = new Reuters();
		Document document1 = createReutersDocument(r);
		documents.add(document1);
		
		//Let's clean everything first
		writer.deleteAll();
		
		writer.addDocuments(documents);
		writer.commit();
	    writer.close();
		
	}
	public static void main(String[] args) throws Exception 
	{
		IndexWriter writer = createWriter();
		List<Document> documents = new ArrayList<>();
		
		Document document1 = createDocument(1, "Lokesh", "Gupta", "howtodoinjava.com");
		documents.add(document1);
		
		Document document2 = createDocument(2, "Brian", "Schultz", "example.com");
		documents.add(document2);
		
		//Let's clean everything first
		writer.deleteAll();
		
		writer.addDocuments(documents);
		writer.commit();
	    writer.close();
	}

	private static Document createReutersDocument(Reuters r) 
	{
//	    private Integer NEWID;
//	    private String DATE;
//	    private String TOPICS;
//	    private String PLACES;
//	    private String PEOPLE;
//	    private String ORGS;
//	    private String EXCHANGES;
//	    private String COMPANIES;
//	    private String UNKNOWN;
//	    private Text TEXT;
//		 private String TITLE;
//		    private String DATELINE;
//		    private String BODY;		
	    
    	Document document = new Document();
    	//document.add(new TextField("id", r.NEWID , Field.Store.YES));
    	document.add(new TextField("DATE", r.getDATE() , Field.Store.YES));
    	document.add(new TextField("TOPICS", r.getTOPICS() , Field.Store.YES));
    	document.add(new TextField("PLACES", r.getPLACES() , Field.Store.YES));
    	document.add(new TextField("PEOPLE", r.getPEOPLE() , Field.Store.YES));
    	document.add(new TextField("ORGS", r.getORGS() , Field.Store.YES));
    	document.add(new TextField("EXCHANGES", r.getEXCHANGES() , Field.Store.YES));
    	document.add(new TextField("COMPANIES", r.getCOMPANIES() , Field.Store.YES));
    	document.add(new TextField("UNKNOWN", r.getUNKNOWN() , Field.Store.YES));
    	document.add(new TextField("TITLE", r.getTEXT().getTITLE() , Field.Store.YES));
    	document.add(new TextField("DATELINE", r.getTEXT().getDATELINE() , Field.Store.YES));
    	document.add(new TextField("BODY", r.getTEXT().getBODY() , Field.Store.YES));
    	return document;
    }
	private static Document createDocument(Integer id, String firstName, String lastName, String website) 
	{
    	Document document = new Document();
    	document.add(new StringField("id", id.toString() , Field.Store.YES));
    	document.add(new TextField("firstName", firstName , Field.Store.YES));
    	document.add(new TextField("lastName", lastName , Field.Store.YES));
    	document.add(new TextField("website", website , Field.Store.YES));
    	return document;
    }
	private static IndexWriter createWriter() throws IOException 
	{
		FSDirectory dir = FSDirectory.open(Paths.get(INDEX_DIR));
		IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
		IndexWriter writer = new IndexWriter(dir, config);
		return writer;
	}
}
