import java.util.*;

public class Categories {
   private Vector<String> categories = new Vector();
   
   public void addCategories(String _category) {
      this.categories.add(_category);
   }
   
   public Vector getCategories() {
      return this.categories;
   }
}