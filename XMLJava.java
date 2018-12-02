import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;


public class XMLJava extends DefaultHandler implements ActionListener{
   
   private JFrame mainFrame = new JFrame();
   private JComboBox xmlSelection;
   private JTable xmlDetails;
   private JScrollPane tableContainer;
   private DefaultTableModel model;
   private boolean resultsStart = false;
   private java.util.List resultCollection = Collections.synchronizedList(new ArrayList());
   private Results result;
   private Ratings rating;
   private Categories category;
   private Vector rowData;
   private Vector indivRow;
   private Vector columnData;
   private String currentTag;
   private String filename = "RochesterSushi.xml";
   
   public XMLJava() {
      createGUI();
   }
   
   public void readData(String filename) {
      try {
         XMLReader xr = XMLReaderFactory.createXMLReader();
         xr.setContentHandler(this);
         xr.setErrorHandler(this);
   
         FileReader reader = new FileReader(filename);
         xr.parse(new InputSource(reader));
      }
      catch(Exception e) {}
   }
   
   public void writeData(String _filename) {
      String outputName = _filename.split(".")[0] + "_out.xml";
      System.out.println(outputName);
   }
   
   public void storeJtableFormat() {
      rowData = new Vector();
      columnData = new Vector();
      for (int i = 0; i < resultCollection.size(); i++) {
         Results resultItem = (Results)resultCollection.get(i);
         indivRow = new Vector();
         indivRow.addElement(resultItem.getTitle());
         indivRow.addElement(resultItem.getAddress());
         indivRow.addElement(resultItem.getPhone());
         indivRow.addElement(resultItem.getRating().getAverageRating());
         indivRow.addElement(resultItem.getRating().getTotalRating());
         indivRow.addElement(resultItem.getRating().getLastReviewDate());
         rowData.addElement(indivRow);
      }
      columnData.addElement("Title");
      columnData.addElement("Address");
      columnData.addElement("Phone");
      columnData.addElement("Average Rating");
      columnData.addElement("Total Ratings");
      columnData.addElement("Last Review Date"); 
   }  
   
   public void testWorking() {
      for (int i = 0; i < resultCollection.size(); i++) {
         Results resultItem = (Results)resultCollection.get(i);
         System.out.println(resultItem.getTitle());
      }
   }
   
   public void loadTable() {
      String selection = xmlSelection.getSelectedItem().toString();
      System.out.println(selection);
      switch(selection) {
         case "Rochester Sushi":
            filename = "RochesterSushi.xml";
            readData(filename);
            storeJtableFormat();
            updateJtable();
         case "San Francisco Sushi":
            filename="SanFranciscoSushi.xml";
            readData(filename);
            storeJtableFormat();
            updateJtable();
      }
   }
   
   public void updateJtable() {
      model = (DefaultTableModel)xmlDetails.getModel();
      model.setDataVector(rowData, columnData);
      model.fireTableDataChanged();
    //   model = new DefaultTableModel(rowData, columnData);
//       xmlDetails.setModel(model);
      // xmlDetails.setGridColor(Color.BLUE);
//       tableContainer = new JScrollPane(xmlDetails);
//       mainFrame.add(BorderLayout.CENTER, tableContainer);
 mainFrame.revalidate();
   }
   
   public void createGUI() {
      mainFrame.setLayout(new BorderLayout());
      
      xmlSelection = new JComboBox();
      xmlSelection.addItem(" ");
      xmlSelection.addItem("Rochester Sushi");
      xmlSelection.addItem("San Francisco Sushi");
      xmlSelection.addActionListener(this);
      mainFrame.add(xmlSelection, BorderLayout.NORTH);
      
      model = new DefaultTableModel(rowData, columnData);
      xmlDetails = new JTable(model);
      xmlDetails.setGridColor(Color.BLUE);
      tableContainer = new JScrollPane(xmlDetails);
      mainFrame.add(tableContainer, BorderLayout.CENTER);
      
      mainFrame.setSize(1500,900);
      mainFrame.setVisible(true);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE); 
   }

   public void startElement(String namespace,String localName, String sElement, Attributes attrList ) {
      currentTag = sElement;
      if (sElement.equals("Result")) {
         resultsStart = true;
         result = new Results();      
      }
      if (sElement.equals("Rating")) {
         rating = new Ratings();      
      }
      if (sElement.equals("Categories")) {
         category = new Categories();      
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
            rating.setTotalRating(content);
         }
      }
      if (currentTag.equals("TotalReviews")) {
         if(content.trim().length() > 0) {
            rating.setTotalReviews(content);
         }
      }
      if (currentTag.equals("LastReviewDate")) {
         if(content.trim().length() > 0) {
            rating.setLastReviewDate(content);
         }
      }
      if (currentTag.equals("LastReviewIntro")) {
         if(content.trim().length() > 0) {
            rating.setLastReviewIntro(content);
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
      if (currentTag.equals("Category")) {
         if(content.trim().length() > 0) {
            category.addCategories(content);
         }
      }
   }

   public void endElement(String namespace,String localName, String eElement) {
      if (eElement.equals("Result")) {
         resultsStart = false;
         resultCollection.add(result);
      }
      if (eElement.equals("Rating")) {
         result.setRating(rating);
      }
      if (eElement.equals("Categories")) {
         result.setCategories(category);
      }
   }

   
   public static void main(String [] args) {
      XMLJava handler = new XMLJava();
   }
   
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == xmlSelection) {
         loadTable();
      }
   }
}
