import java.io.ObjectInputStream.GetField;

public class Booking {

	private int bookingID;// id of every booking
	private String email;// customers email, must have @ in this systerm
	private String surburb;// cinema's location
	private String movieName;// movies name of each session
	private String time;// move playing time
	private String duration;// movie duration
	// constructor

	public Booking(int bookingID, String email, String surburb, String movieName, String time, String duration) {

		this.bookingID = bookingID;
		this.email = email;
		this.surburb = surburb;
		this.movieName = movieName;
		this.time = time;
		this.duration = duration;
	}

	// get booking ID
	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	// get email
	public String getEmail() {
		return email;
	}

	// set value of email
	public void setEmail(String email) {
		this.email = email;
	}

	// get customers surburb
	public String getSurburb() {
		return surburb;
	}

	public void setSurburb(String surburb) {
		this.surburb = surburb;
	}

	// get movies name
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	// get movie play time
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	// get duration of each movie
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}