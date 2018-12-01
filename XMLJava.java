import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class XMLJava extends DefaultHandler{

//    public XMLJava()
//    {
//        readFile();
//
//    }

//    public void readFile()
//    {
//        ResultHandler
//    }

   public void startElement(String namespace,String localName, String sElement, Attributes attrList )
   {
     System.out.println("Starting Element : " + sElement);

   }

   public void endElement(String namespace,String localName, String eElement)
   {
      System.out.println("Ending Element : " + eElement);
   }
   
   public void characters(char[] content, int start, int len)
   {
      String text = new String(content, start, len );
      System.out.println("Content : " + text);
   }
   
   public static void main(String [] args)
   {
      try
      {
         XMLJava handler = new XMLJava();
         XMLReader xr = XMLReaderFactory.createXMLReader();
         xr.setContentHandler(handler);
         xr.setErrorHandler(handler);
   
         FileReader reader = new FileReader("RochesterSushi.xml");
         xr.parse(new InputSource(reader));
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}