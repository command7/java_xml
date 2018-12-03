/**
*  Purpose: This program parses through an xml file, gathers necessary data, writes it to a file
*           and displays it in a graphical user interface.
*  @author: Vijay Raj Saravanan Radhakrishnan
*  Date: 2nd December, 2018
*/
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.xml.stream.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class XMLJava extends DefaultHandler implements ActionListener{
   /** Main container of all other GUI components */
   private JFrame mainFrame = new JFrame();
   /** Combo box containing options of difference xml files */
   private JComboBox xmlSelection;
   /** JTable that will display parsed details */
   private JTable xmlDetails;
   /** Scrollpane to scroll through JTable */
   private JScrollPane tableContainer;
   /** Table model for JTable */
   private DefaultTableModel model;
   /** Collection that stores blocks of Result from XML */
   private java.util.List resultCollection = Collections.synchronizedList(new ArrayList());
   /** Object storing information of each Result block */
   private Results result;
   /** Object storing information in Rating blocks */
   private Ratings rating;
   /** Object storing information in Categories blocks */
   private Categories category;
   /** Rows of information to be displayed in JTable */
   private Vector rowData;
   /** Single row of information to be displayed in JTable */
   private Vector indivRow;
   /** Column headers for Jtable */
   private Vector columnData;
   /** Current XML tag that is being parsed */
   private String currentTag;
   /** Default fil */
   private String filename = "RochesterSushi.xml";
   
/**
*  Constructor creates the foundational Graphical User interface
*/
   public XMLJava() {
      createGUI();
   }//end of constructor
   
/**
*  Parses data from the XML file
*  @param filename Name of XML file
*/
   public void readData(String filename) {
      try {
         XMLReader xr = XMLReaderFactory.createXMLReader();
         xr.setContentHandler(this);
         xr.setErrorHandler(this);
   
         FileReader reader = new FileReader(filename);
         xr.parse(new InputSource(reader));
      }
      catch(Exception e) {}
   }//end of readData()
   
/**
*  Writes XML data to output file
*  @param _filename Name of file to which XML has to be written to
*/
   public void writeData(String _filename) {
      String outputName = _filename.split("\\.")[0] + "_out.xml";
      try {
         OutputStream os = new FileOutputStream(new File(outputName));
   		XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(
   								new OutputStreamWriter(new FileOutputStream(new File(outputName))));
         xsw.writeStartDocument();
         xsw.writeStartElement("results");
         for(int i = 0; i < resultCollection.size(); i++) {
            Results resultItem = (Results)resultCollection.get(i);
            xsw.writeStartElement("Result");
               xsw.writeStartElement("Title");
                  xsw.writeCharacters(resultItem.getTitle());
               xsw.writeEndElement();
               xsw.writeStartElement("Address");
                  xsw.writeCharacters(resultItem.getAddress());
               xsw.writeEndElement();
               xsw.writeStartElement("Phone");
                  xsw.writeCharacters(resultItem.getPhone());
               xsw.writeEndElement();
               xsw.writeStartElement("Rating");
                  xsw.writeStartElement("AverageRating");
                     xsw.writeCharacters(resultItem.getRating().getAverageRating());
                  xsw.writeEndElement();
                  xsw.writeStartElement("TotalRatings");
                     xsw.writeCharacters(resultItem.getRating().getTotalRating());
                  xsw.writeEndElement();
                  xsw.writeStartElement("LastReviewDate");
                     xsw.writeCharacters(resultItem.getRating().getLastReviewDate());
                  xsw.writeEndElement();
               xsw.writeEndElement();
            xsw.writeEndElement();         
         }
         xsw.writeEndElement();
         xsw.writeEndDocument();
         xsw.flush();
         xsw.close();
      }
      catch (Exception e) {}
   }//end of writeData()
   
/**
*  Stores parsed XML data into vector rows to display in JTable
*/
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
   }//end of storeJtableFormat()  
   
/**
*  Read xml data, write it to a file and display it in JTable based on the XML file chosen
*/
   public void loadTable() {
      
      String selection = xmlSelection.getSelectedItem().toString();
      switch(selection) {
         case "Rochester Sushi":
            filename = "RochesterSushi.xml";
            readData(filename);
            storeJtableFormat();
            updateJtable();
            writeData(filename);
            break;
         case "San Francisco Sushi":
            filename="SanFranciscoSushi.xml";
            readData(filename);
            storeJtableFormat();
            updateJtable();
            writeData(filename);
            break;
      }
   }//end of loadTable()
   
/**
*  Update data in JTable based on XML selection
*/
   public void updateJtable() {
      // DefaultTableModel tmodel = (DefaultTableModel)xmlDetails.getModel();
//       tmodel.getDataVector().removeAllElements();
//          model.setRowCount(0);
//          model.fireTableDataChanged();
         //model.setRowCount(0);
         model = new DefaultTableModel(rowData, columnData);
         xmlDetails.setModel(model);
         mainFrame.revalidate();
   }//end of updateJtable()
   
/**
*  Creates foundational Graphical user interface with a blank JTable
*/
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

/**
*  Invoked when a starting XML tag is parsed
*  @param namespace The Namespace URI, or the empty string
*  @param localName The local name (without prefix), or the empty string if Namespace processing is not being performed.
*  @param sElement Qualified name
*  @param attrList Attributes attached to the element
*/
   public void startElement(String namespace,String localName, String sElement, Attributes attrList ) {
      currentTag = sElement;
      if (sElement.equals("Result")) {
         result = new Results();      
      }
      if (sElement.equals("Rating")) {
         rating = new Ratings();      
      }
      if (sElement.equals("Categories")) {
         category = new Categories();      
      }
   }//end of startElement()
   
/**
*  Invoked when content with starting and ending tags is parsed
*  @param text The characters
*  @param start Starting position of character array
*  @param len Number of characters in the character array
*/
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
            Long newDate = new Long(content);
            Date d = new Date(newDate);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String outDate = dateFormat.format(d);
            rating.setLastReviewDate(outDate);
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
   }//end of Characters()

/**
*  Invoked when an ending XML tag is parsed
*  @param namespace The Namespace URI, or the empty string
*  @param localName The local name (without prefix), or the empty string if Namespace processing is not being performed.
*  @param eElement Qualified name
*/
   public void endElement(String namespace,String localName, String eElement) {
      if (eElement.equals("Result")) {
         resultCollection.add(result);
      }
      if (eElement.equals("Rating")) {
         result.setRating(rating);
      }
      if (eElement.equals("Categories")) {
         result.setCategories(category);
      }
   }//end of endElement()

/**
*  Initiates an instance of XMLJave
*  @param args Command Line Arguments
*/
   public static void main(String [] args) {
      XMLJava handler = new XMLJava();
   }//end of main
   
/**
*  Event listener for GUI components
*  @param e Event that is triggering an action
*/
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == xmlSelection) {
         loadTable();
      }
   }//end of actionPerformed()
}
