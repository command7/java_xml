import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;

public class XMLJava extends DefaultHandler{
   
   private boolean resultsStart = false;
   private List resultCollection = Collections.synchronizedList(new ArrayList());
   private Results result;
   private Vector title;
   private String currentTag;
   
   public void testWorking() {
      for (int i = 0; i < resultCollection.size(); i++) {
         Results resultItem = (Results)resultCollection.get(i);
         System.out.println(resultItem.getTitle());
      }
   }

   public void setResults() {
   }

   public void startElement(String namespace,String localName, String sElement, Attributes attrList ) {
      currentTag = sElement;
      //System.out.println(sElement);
      if (sElement.equals("Result")) {
         resultsStart = true;
         result = new Results();      
      }
   }
   
   public void characters(char[] text, int start, int len) {
      String content = new String(text, start, len );
      content.replace("\n", " ");
      content.replace(" ", "");
      content = content.trim();    
      if (currentTag.equals("Title")) {
         System.out.println(content);
         result.setTitle(content);
         resultCollection.add(result);
      }
   }

   public void endElement(String namespace,String localName, String eElement) {
      //System.out.println(eElement);
      if (eElement.equals("Result")) {
         resultsStart = false;
         System.out.println(result);
      }
   }

   
   public static void main(String [] args) {
      try {
         XMLJava handler = new XMLJava();
         XMLReader xr = XMLReaderFactory.createXMLReader();
         xr.setContentHandler(handler);
         xr.setErrorHandler(handler);
   
         FileReader reader = new FileReader("RochesterSushi.xml");
         xr.parse(new InputSource(reader));
//          handler.testWorking();
      }
      catch (SAXException e) {
	      e.printStackTrace();
	   }
	   catch (IOException e) {
	      e.printStackTrace();
	   } 
   }
}
