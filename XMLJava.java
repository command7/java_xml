import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;

public class XMLJava extends DefaultHandler{
   
   private boolean resultsStart = false;
   private List resultCollection = Collections.synchronizedList(new ArrayList());
   private Results result;
   private Ratings rating;
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
      if (sElement.equals("Result")) {
         resultsStart = true;
         result = new Results();      
      }
      if (sElement.equals("Rating")) {
         resultsStart = true;
         rating = new Ratings();      
      }
   }
   
   public void characters(char[] text, int start, int len) {
      String content = new String(text, start, len );    
      if (currentTag.equals("Title")) {
         if(content.trim().length() > 0) {
            result.setTitle(content);
         }
      }
      if (currentTag.equals("Address")) {
         if(content.trim().length() > 0) {
            result.setAddress(content);
         }
      }
      if (currentTag.equals("City")) {
         if(content.trim().length() > 0) {
            result.setCity(content);
         }
      }
      if (currentTag.equals("State")) {
         if(content.trim().length() > 0) {
            result.setState(content);
         }
      }
      if (currentTag.equals("Phone")) {
         if(content.trim().length() > 0) {
            result.setPhone(content);
         }
      }
      if (currentTag.equals("Latitude")) {
         if(content.trim().length() > 0) {
            result.setLatitude(content);
         }
      }
      if (currentTag.equals("Longitude")) {
         if(content.trim().length() > 0) {
         result.setLongitude(content);
         }
      }
      if (currentTag.equals("Distance")) {
         if(content.trim().length() > 0) {
            result.setDistance(content);
         }
      }
      if (currentTag.equals("AverageRating")) {
         if(content.trim().length() > 0) {
            rating.setAverageRating(content);
         }
      }
      if (currentTag.equals("TotalRatings")) {
         if(content.trim().length() > 0) {
            result.setTotalRatings(content);
         }
      }
      if (currentTag.equals("TotalReviews")) {
         if(content.trim().length() > 0) {
            result.setTotalReviews(content);
         }
      }
      if (currentTag.equals("LastReviewDate")) {
         if(content.trim().length() > 0) {
            result.setLastReviewDate(content);
         }
      }
      if (currentTag.equals("LastReviewIntro")) {
         if(content.trim().length() > 0) {
            result.setLastReviewIntro(content);
         }
      }
      if (currentTag.equals("Url")) {
         if(content.trim().length() > 0) {
            result.setUrl(content);
         }
      }
      if (currentTag.equals("ClickUrl")) {
         if(content.trim().length() > 0) {
            result.setClickUrl(content);
         }
      }
      if (currentTag.equals("MapUrl")) {
         if(content.trim().length() > 0) {
            result.setMapUrl(content);
         }
      }
      if (currentTag.equals("BusinessUrl")) {
         if(content.trim().length() > 0) {
            result.setBusinessUrl(content);
         }
      }
      if (currentTag.equals("BusinessClickUrl")) {
         if(content.trim().length() > 0) {
            result.setBusinessClickUrl(content);
         }
      }
   }

   public void endElement(String namespace,String localName, String eElement) {
      //System.out.println(eElement);
      if (eElement.equals("Result")) {
         resultsStart = false;
         resultCollection.add(result);
      }
      if (eElement.equals("Rating")) {
         result.setRating(rating);
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
         handler.testWorking();
      }
      catch (SAXException e) {
	      e.printStackTrace();
	   }
	   catch (IOException e) {
	      e.printStackTrace();
	   } 
   }
}
