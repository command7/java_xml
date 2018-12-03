/**
*  Purpose: Saves data from Ratings block
*  @author Vijay Raj Saravanan Radhakrishnan
*  Date: 3rd December, 2018
*/
public class Ratings
{
   /** Data inside AverageRating field */
   private String averageRating;
   /** Data inside TotalRating field */
   private String totalRating;
   /** Data inside TotalReviews field */
   private String totalReviews;
   /** Data inside LastReviewDate field */
   private String lastReviewDate;
   /** Data inside LastReviewIntro field */
   private String lastReviewIntro;
   
/**
*  Getter method used to retreive AverageRating
*  @return AverageRating data
*/
   public String getAverageRating() {
      return this.averageRating;
   }
   
/**
*  Getter method used to retreive TotalRating
*  @return TotalRating data
*/
   public String getTotalRating() {
      return this.totalRating;
   }
   
/**
*  Getter method used to retreive TotalReviews
*  @return TotalReviews data
*/
   public String getTotalReviews() {
      return this.totalReviews;
   }
   
/**
*  Getter method used to retreive LastReviewDate
*  @return LastReviewDate data
*/
   public String getLastReviewDate() {
      return this.lastReviewDate;
   }
   
/**
*  Getter method used to retreive LastReviewIntro
*  @return LastReviewIntro data
*/
   public String getLastReviewIntro() {
      return this.lastReviewIntro;
   }
   
/**
*  Getter methods used to set AverageRating
*  @param _averageRating AverageRating data
*/
   public void setAverageRating(String _averageRating) {
      this.averageRating = _averageRating;
   }
   
/**
*  Getter methods used to set TotalRating
*  @param _totalRating TotalRating data
*/
   public void setTotalRating(String _totalRating) {
      this.totalRating = _totalRating;
   }
   
/**
*  Getter methods used to set TotalReviews
*  @param _totalReviews AverageRating data
*/
   public void setTotalReviews(String _totalReviews) {
      this.totalReviews = _totalReviews;
   }
  
/**
*  Getter methods used to set LastReviewDate
*  @param _lastReviewDate LastReviewDate data
*/ 
   public void setLastReviewDate(String _lastReviewDate) {
      this.lastReviewDate = _lastReviewDate;
   }
   
/**
*  Getter methods used to set LastReviewIntro
*  @param _lastReviewIntro LastReviewIntro data
*/
   public void setLastReviewIntro(String _lastReviewIntro) {
      this.lastReviewIntro = _lastReviewIntro;
   }
}