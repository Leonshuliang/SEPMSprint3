
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver{
	
 private List<Session> listSession=new ArrayList<Session>();
 private List<Booking> listBooking=new ArrayList<Booking>();

 public void putSessions()
 {
	 /** 
	  * p1- p7 is instance of adult storage in listAdult 
	  */
	 Session s1=new Session(1, "Gone With the Wind  ", "11:00 am","2 hours");
	 Session s2=new Session(2, "Jaws                ", "1:00 pm","2 hours");
	 Session s3=new Session(3, "The Ten Commandments", "3:00 pm","2 hours");
	 Session s4=new Session(4, "Doctor Zhivago      ", "5:00 pm","2 hours");
	 Session s5=new Session(5, "The Sound of Music  ", "7:00 pm","2 hours");
	
	 /** 
	  * p10 is instance of baby storage in listBaby
	  */
	
	 listSession.add(s1);
	 listSession.add(s2);
	 listSession.add(s3);
	 listSession.add(s4);
	 listSession.add(s5);
 }
 
 
 //book a session
 public int bookID=1;
	public void bookSession() {
		//int locationNo;
		
		int sessionID;
		String sessionStr;
		String locationStr;
		String email;
		Menu m = new Menu();// instance of menu
		m.locationMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location you want to book");
	    locationStr = sc.nextLine();
	    
	    System.out.println("Enter custom's email");
		email=sc.nextLine();
		//locationNo = Integer.parseInt(locationStr);
		showAllSessions();
		System.out.println("Enter the session you want to book");
		sessionStr=sc.nextLine();
		sessionID=Integer.parseInt(sessionStr);
		Iterator<Session> it=listSession.iterator();//
	    while(it.hasNext()){  
	    Session s=(Session)it.next();
	   if(sessionID==s.getSessionID())
	   {
	   Booking b=new Booking(bookID,email, locationStr, s.getMovieName(), s.getTime(), s.getDuration());
			listBooking.add(b);
	        bookID++;
	   }
	     }
		
	}
 
//List all the sessions
public void showAllSessions(){
 System.out.println("SessionID\t\t"+"MovieName\t\t"+"Time\t\t"+"Durations"+"\n");
 
 Iterator<Session> it=listSession.iterator();//
 while(it.hasNext())
 {
  Session p=(Session)it.next();
  System.out.println(p.getSessionID()+"\t\t"+p.getMovieName()+"\t\t"+p.getTime()+"\t\t"+p.getDuration()+"\t\t");
 }
}
//
public void listAllBookings(){
	 System.out.println("BookingID\t\t"+"Email\t\t"+"Surburb\t\t"+"MovieName\t\t"+"Time\t\t"+"Durations"+"\n");
	 
	 Iterator<Booking> it=listBooking.iterator();//
	 while(it.hasNext())
	 {
	  Booking p=(Booking)it.next();
	  System.out.println(p.getBookingID()+"\t\t"+p.getEmail()+"\t\t"+p.getSurburb()+"\t\t"+p.getMovieName()+"\t\t"+p.getTime()+"\t\t"+p.getDuration()+"\t\t");
	 }
	}

}