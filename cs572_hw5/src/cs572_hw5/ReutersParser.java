package cs572_hw5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class ReutersParser {

	public static void main(String[] args) throws IOException,SAXException, TikaException {
		
		  File dir = new File("/Users/jessiekuo/Desktop/CS572_HW4/solr-7.7.0/EdgeLists/reutersnews");
		  PrintWriter writer = new PrintWriter(new FileWriter("big.txt"));
		  int count = 1;
		  for (File file : dir.listFiles()) { 
		      //detecting the file type
			  FileInputStream inputstream = new FileInputStream(file);
		      BodyContentHandler handler = new BodyContentHandler(-1);
		      Metadata metadata = new Metadata();
		      ParseContext pcontext = new ParseContext();
		      
		      HtmlParser htmlparser = new HtmlParser();
		      htmlparser.parse(inputstream, handler, metadata,pcontext);
		      
		      writer.print(handler.toString());
		      
		      String title =  metadata.get("title");
		      System.out.println(title + " " + count++);
		  }
		  writer.close();	  
		  System.out.println("done");
	}
}
