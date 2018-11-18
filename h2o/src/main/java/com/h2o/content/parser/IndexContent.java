package com.h2o.content.parser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
 
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
//https://howtodoinjava.com/lucene/lucene-index-search-examples/ 
public class IndexContent 
{
    public static void main(String[] args)
    {
        //Input folder
        //String docsPath = "inputFiles";
    	String docsPath = "C:\\Users\\rusye\\git\\h2o\\h2o\\data\\reuters\\sgm";
    	
        //Output folder
        //String indexPath = "indexedFiles";
    	String indexPath = "C:\\Users\\rusye\\git\\h2o\\h2o\\index";
    	
        //Input Path Variable
        final Path docDir = Paths.get(docsPath);
 
        try
        {
            //org.apache.lucene.store.Directory instance
            Directory dir = FSDirectory.open( Paths.get(indexPath) );
             
            //analyzer with the default stop words
            Analyzer analyzer = new StandardAnalyzer();
             
            //IndexWriter Configuration
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
             
            //IndexWriter writes new index files to the directory
            IndexWriter writer = new IndexWriter(dir, iwc);
             
            //Its recursive method to iterate all files and directories
            indexDocs(writer, docDir);
 
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
     
    static void indexDocs(final IndexWriter writer, Path path) throws IOException 
    {
        //Directory?
        if (Files.isDirectory(path)) 
        {
            //Iterate directory
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() 
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
                {
                    try
                    {
                        //Index this file
                        indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
                    } 
                    catch (IOException ioe) 
                    {
                        ioe.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } 
        else
        {
            //Index this file
            indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
        }
    }
 
    static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException 
    {
        try (InputStream stream = Files.newInputStream(file)) 
        {
            //Create lucene Document
            Document doc = new Document();
             
            doc.add(new StringField("DATE", file.toString(), Field.Store.YES));
            doc.add(new StringField("TOPICS", file.toString(), Field.Store.YES));
            
            doc.add(new StringField("PLACES", file.toString(), Field.Store.YES));
            doc.add(new StringField("PEOPLE", file.toString(), Field.Store.YES));
            doc.add(new StringField("ORGS", file.toString(), Field.Store.YES));
            doc.add(new StringField("EXCHANGES", file.toString(), Field.Store.YES));
            doc.add(new StringField("COMPANIES", file.toString(), Field.Store.YES));
            doc.add(new StringField("UNKNOWN", file.toString(), Field.Store.YES));
            doc.add(new StringField("TEXT", file.toString(), Field.Store.YES));
            doc.add(new StringField("TITLE", file.toString(), Field.Store.YES));
            doc.add(new StringField("DATELINE", file.toString(), Field.Store.YES));
            doc.add(new StringField("BODY", file.toString(), Field.Store.YES));
            doc.add(new StringField("LEWISSPLIT", file.toString(), Field.Store.YES));
            doc.add(new StringField("CGISPLIT", file.toString(), Field.Store.YES));
            doc.add(new StringField("OLDID", file.toString(), Field.Store.YES));
            doc.add(new StringField("NEWID", file.toString(), Field.Store.YES));
            
            doc.add(new LongPoint("modified", lastModified));
            doc.add(new TextField("contents", new String(Files.readAllBytes(file)), Store.YES));
             

            
            //Updates a document by first deleting the document(s) 
            //containing <code>term</code> and then adding the new
            //document.  The delete and then add are atomic as seen
            //by a reader on the same index
            writer.updateDocument(new Term("path", file.toString()), doc);
        }
    }
    
    static void indexDocBK(IndexWriter writer, Path file, long lastModified) throws IOException 
    {
        try (InputStream stream = Files.newInputStream(file)) 
        {
            //Create lucene Document
            Document doc = new Document();
             
            doc.add(new StringField("path", file.toString(), Field.Store.YES));
            doc.add(new LongPoint("modified", lastModified));
            doc.add(new TextField("contents", new String(Files.readAllBytes(file)), Store.YES));
             
            //Updates a document by first deleting the document(s) 
            //containing <code>term</code> and then adding the new
            //document.  The delete and then add are atomic as seen
            //by a reader on the same index
            writer.updateDocument(new Term("path", file.toString()), doc);
        }
    }    
}
