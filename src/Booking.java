
public class Booking {
 private int bookingID;//
 private String email;//
 private String surburb;//
 private String movieName;//
 private String time;//
 private String duration;//
 public Booking(int bookingID,String email,String surburb,String movieName,String time,String duration){
  this.bookingID=bookingID;
  this.email=email;
  this.surburb=surburb;
  this.movieName=movieName;
  this.time=time;
  this.duration=duration;
 }
 //
 public int getBookingID() {
  return bookingID;
 }
 public void setBookingID(int bookingID) {
  this.bookingID=bookingID;
 }

 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getSurburb() {
  return surburb;
 }
 public void setSurburb(String surburb) {
  this.surburb = surburb;
 }
 public String getMovieName() {
  return movieName;
 }
 public void setMovieName(String movieName) {
  this.movieName = movieName;
 }
 public String getTime() {
  return time;
 }
 public void setTime(String time) {
  this.time = time;
 }
 public String getDuration() {
  return duration;
 }
 public void setDuration(String duration) {
  this.duration = duration;
 }

 
}