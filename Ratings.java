public class Ratings
{
   private double averageRating;
   private int totalRating;
   private int totalReviews;
   private int lastReviewDate;
   private String lastReviewIntro;
   
   public double getAverageRating() {
      return this.averageRating;
   }
   
   public int getTotalRating() {
      return this.totalRating;
   }
   
   public int getTotalReviews() {
      return this.totalReviews;
   }
   
   public int getLastReviewDate() {
      return this.lastReviewDate;
   }
   
   public String getLastReviewIntro() {
      return this.lastReviewIntro;
   }
   
   public void setAverageRating(double _averageRating) {
      this.averageRating = _averageRating;
   }
   
   public void setTotalRating(int _totalRating) {
      this.totalRating = _totalRating;
   }
   
   public void setTotalReviews(int _totalReviews) {
      this.totalReviews = _totalReviews;
   }
   
   public void setLastReviewDate(int _lastReviewDate) {
      this.lastReviewDate = _lastReviewDate;
   }
   
   public void setLastReviewIntro(String _lastReviewIntro) {
      this.lastReviewIntro = _lastReviewIntro;
   }
}