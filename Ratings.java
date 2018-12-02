public class Ratings
{
   private String averageRating;
   private String totalRating;
   private String totalReviews;
   private String lastReviewDate;
   private String lastReviewIntro;
   
   public String getAverageRating() {
      return this.averageRating;
   }
   
   public String getTotalRating() {
      return this.totalRating;
   }
   
   public String getTotalReviews() {
      return this.totalReviews;
   }
   
   public String getLastReviewDate() {
      return this.lastReviewDate;
   }
   
   public String getLastReviewIntro() {
      return this.lastReviewIntro;
   }
   
   public void setAverageRating(String _averageRating) {
      this.averageRating = _averageRating;
   }
   
   public void setTotalRating(String _totalRating) {
      this.totalRating = _totalRating;
   }
   
   public void setTotalReviews(String _totalReviews) {
      this.totalReviews = _totalReviews;
   }
   
   public void setLastReviewDate(String _lastReviewDate) {
      this.lastReviewDate = _lastReviewDate;
   }
   
   public void setLastReviewIntro(String _lastReviewIntro) {
      this.lastReviewIntro = _lastReviewIntro;
   }
}