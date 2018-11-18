//package com.h2o.content.parser;
//
//import java.io.File;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.Field.Index;
//import org.apache.lucene.document.Field.Store;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.tika.Tika;
//
//public class LuceneIndexer {
//	private final Tika tika;
//	private final IndexWriter writer;
//
//	public LuceneIndexer(Tika tika, IndexWriter writer) {
//		this.tika = tika;
//		this.writer = writer;
//	}
//
//	public void indexDocument(File file) throws Exception {
//		Reader fulltext = tika.parse(file);
//		try {
//			Document document = new Document();
//			document.add(new Field("filename", file.getName(), Store.YES, Index.ANALYZED));
//			document.add(new Field("fulltext", fulltext));
//			writer.addDocument(document);
//		} finally {
//			fulltext.close();
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		IndexWriter writer = new IndexWriter(new SimpleFSDirectory(new File(args[0])),
//				new StandardAnalyzer(Version.LUCENE_30), MaxFieldLength.UNLIMITED);
//		try {
//			LuceneIndexer indexer = new LuceneIndexer(new Tika(), writer);
//			for (int i = 1; i < args.length; i++) {
//				indexer.indexDocument(new File(args[i]));
//			}
//		} finally {
//			writer.close();
//		}
//	}
//
//}
