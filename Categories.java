import java.util.*;

public class Categories {
   private Vector<String> categories;
   
   public void addCategories(String _category) {
      this.categories.add(_category);
   }
   
   public Vector getCategories() {
      return this.categories;
   }
}