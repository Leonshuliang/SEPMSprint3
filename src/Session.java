
public class Session {
	 private int sessionID;//
	 private String movieName;//
	 private String time;//
	 private String duration;//
	

	public Session(int sessionID, String movieName, String time, String duration) {
		
		  this.sessionID=sessionID;
		  this.movieName=movieName;
		  this.time=time;
		  this.duration=duration;
		  
	}
	public int getSessionID() {
		return sessionID;
	}
	
	public void setSessionId(int sessionID) {
		this.sessionID=sessionID;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName=movieName;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time=time;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration=duration;
	}
	
}
