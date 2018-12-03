/**
*  Purpose: This program stores information in Result section of data parsed
*           from XML file.
*  @author Vijay Raj Saravanan Radhakrishnan
*  Date: 2nd December, 2018
*/
public class Results {
   /** Data inside Title tag */
   private String title;
   /** Data inside Address tag */
   private String address;
   /** Data inside City tag */
   private String city;
   /** Data inside State tag */
   private String state;
   /** Data inside Phone tag */
   private String phone;
   /** Data inside Latitude tag*/
   private String latitude;
   /** Data inside Longitude tag */
   private String longitude;
   /** Data inside Rating block */
   private Ratings rating;
   /** Data inside Distance tag */
   private String distance;
   /** Data inside URL tag */
   private String url;
   /** Data inside ClickURl tag */
   private String clickUrl;
   /** Data inside MapURL */
   private String mapUrl;
   /** Data inside BusinessURL tag */
   private String businessUrl;
   /** Data inside BusinessURL tag */
   private String businessClickUrl;
   /** Data inside Categories tag */
   private Categories categories;
   
/**
*  Setter method used to set title
*  @param _title Title data
*/
   public void setTitle(String _title) {
      this.title = _title;
   }
   
/**
*  Setter method used to set address
*  @param _address address data
*/
   public void setAddress(String _address) {
      this.address = _address;
   }
   
/**
*  Setter method used to set city
*  @param _city city data
*/
   public void setCity(String _city) {
      this.city = _city;
   }
   
/**
*  Setter method used to set state
*  @param _state State data
*/
   public void setState(String _state) {
      this.state = _state;
   }
   
/**
*  Setter method used to set Phone
*  @param _phone phone data
*/
   public void setPhone(String _phone) {
      this.phone = _phone;
   }
   
/**
*  Setter method used to set latitude
*  @param _lat Latitude data
*/
   public void setLatitude(String _lat) {
      this.latitude = _lat;
   }
   
/**
*  Setter method used to set longitude
*  @param _longitude longitude data
*/
   public void setLongitude(String _longitude) {
      this.longitude = _longitude;
   }
   
/**
*  Setter method used to set distance
*  @param _distance distance data
*/
   public void setDistance(String _distance) {
      this.distance = _distance;
   }
   
/**
*  Setter method used to set URL
*  @param _url URL data
*/
   public void setUrl(String _url) {
      this.url = _url;
   }
   
/**
*  Setter method used to set clickURl
*  @param _clickUrl ClickURL data
*/
   public void setClickUrl(String _clickUrl) {
      this.clickUrl = _clickUrl;
   }
   
/**
*  Setter method used to set mapUrl
*  @param _mapUrl mapUrl data
*/
   public void setMapUrl(String _mapUrl) {
      this.mapUrl = _mapUrl;
   }
   
/**
*  Setter method used to set BusinessUrl
*  @param _busiUrl BusinessUrl data
*/
   public void setBusinessUrl(String _busiUrl) {
      this.businessUrl = _busiUrl;
   }
   
/**
*  Setter method used to set businessClickUrl
*  @param _bClickUrl BusinessClickUrl data
*/
   public void setBusinessClickUrl(String _bClickUrl) {
      this.businessClickUrl = _bClickUrl;
   }
   
/**
*  Setter method used to set rating
*  @param _rating rating data
*/
   public void setRating(Ratings _rating) {
      this.rating = _rating;
   }
   
/**
*  Setter method used to set categories
*  @param _category categories data
*/
   public void setCategories(Categories _category) {
      this.categories = _category;
   }
   
/**
*  Getter method used to retrieve title
*  @return Title data
*/
   public String getTitle() {
      return this.title;
   }
   
/**
*  Getter method used to retrieve Address
*  @return Address data
*/
   public String getAddress() {
      return this.address;
   }
   
/**
*  Getter method used to retrieve City
*  @return City data
*/
   public String getCity() {
      return this.city;
   }
   
/**
*  Getter method used to retrieve State
*  @return State data
*/
   public String getState() {
      return this.state;
   }
   
/**
*  Getter method used to retrieve Phone
*  @return Phone data
*/
   public String getPhone() {
      return this.phone;
   }
   
/**
*  Getter method used to retrieve Latitude
*  @return Latitude data
*/
   public String getLatitude() {
      return this.latitude;
   }
   
/**
*  Getter method used to retrieve Longitude
*  @return Longitude data
*/
   public String getLongitude() {
      return this.longitude;
   }
   
/**
*  Getter method used to retrieve Distance
*  @return Distance data
*/
   public String getDistance() {
      return this.distance;
   }
   
/**
*  Getter method used to Url title
*  @return Url data
*/
   public String getUrl() {
      return this.url;
   }
   
/**
*  Getter method used to retrieve ClickUrl
*  @return _clickUrl data
*/
   public String getClickUrl() {
      return this.clickUrl;
   }
   
/**
*  Getter method used to retrieve MapUrl
*  @return MapUrl data
*/
   public String getMapUrl() {
      return this.mapUrl;
   }
   
/**
*  Getter method used to retrieve BusinessUrl
*  @return BusinessUrl data
*/
   public String getBusinessUrl() {
      return this.businessUrl;
   }
   
/**
*  Getter method used to retrieve BusinessClickUrl
*  @return BusinessClickUrl data
*/
   public String getBusinessClickUrl() {
      return this.businessClickUrl;
   }
   
/**
*  Getter method used to retrieve Rating
*  @return Rating data
*/
   public Ratings getRating() {
      return this.rating;
   }
   
/**
*  Getter method used to retrieve Categories
*  @return Categories data
*/
   public Categories getCategories() {
      return this.categories;
   }
}