public class Results {
   private String id;
   private String title;
   private String address;
   private String city;
   private String state;
   private String phone;
   private double latitude;
   private double longitude;
   private Ratings rating;
   private double distance;
   private String url;
   private String clickUrl;
   private String mapUrl;
   private String businessUrl;
   private String businessClickUrl;
   private Categories categories;
   
   public void setId(String _id) {
      this.id = _id;
   }
   
   public void setTitle(String _title) {
      this.title = _title;
   }
   
   public void setAddress(String _address) {
      this.address = _address;
   }
   
   public void setCity(String _city) {
      this.city = _city;
   }
   
   public void setState(String _state) {
      this.state = _state;
   }
   
   public void setPhone(String _phone) {
      this.phone = _phone;
   }
   
   public void setLatitude(double _lat) {
      this.latitude = _lat;
   }
   
   public void setLongitude(double _longitude) {
      this.longitude = _longitude;
   }
   
   public void setDistance(double _distance) {
      this.distance = _distance;
   }
   
   public void setUrl(String _url) {
      this.url = _url;
   }
   
   public void setClickUrl(String _clickUrl) {
      this.clickUrl = _clickUrl;
   }
   
   public void setMapUrl(String _mapUrl) {
      this.mapUrl = _mapUrl;
   }
   
   public void setBusinessUrl(String _busiUrl) {
      this.businessUrl = _busiUrl;
   }
   
   public void setBusinessClickUrl(String _bClickUrl) {
      this.businessClickUrl = _bClickUrl;
   }
   
   public String getId() {
      return this.id;
   }
   
   public String getTitle() {
      return this.title;
   }
   
   public String getAddress() {
      return this.address;
   }
   
   public String getCity() {
      return this.city;
   }
   
   public String getState() {
      return this.state;
   }
   
   public String getPhone() {
      return this.phone;
   }
   
   public double getLatitude() {
      return this.latitude;
   }
   
   public double getLongitude() {
      return this.longitude;
   }
   
   public double getDistance() {
      return this.distance;
   }
   
   public String getUrl() {
      return this.url;
   }
   
   public String getClickUrl(String _clickUrl) {
      return this.clickUrl;
   }
   
   public String getMapUrl() {
      return this.mapUrl;
   }
   
   public String getBusinessUrl() {
      return this.businessUrl;
   }
   
   public String getBusinessClickUrl() {
      return this.businessClickUrl;
   }
   
   public String toString() {
      return this.title;
   }

}