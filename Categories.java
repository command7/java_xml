import java.util.*;
/**
*  Purpose: Stores info in categories tag
*  @author Vijay Raj Saravanan Radhakrishnan
*  Date: 2nd December, 2018
*/
public class Categories {
   /** Stores all category data */
   private Vector<String> categories = new Vector();
   
/**
*  Add a category to category list
*  @param _category category to be added
*/
   public void addCategories(String _category) {
      this.categories.add(_category);
   }
/**
*  getter method to return category list
*  @return category list
*/
   public Vector getCategories() {
      return this.categories;
   }
}