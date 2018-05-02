
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver {

	private List<Session> listSession = new ArrayList<Session>();
	private List<Booking> listBooking = new ArrayList<Booking>();

	public boolean inputInfo() {
		Verify ver = new Verify();
		String userName;
		String passWord;
		sc = new Scanner(System.in);
		System.out.println(" Welcome to jMoSS !! Please enter your identity information");
		System.out.println("===================================");
		System.out.println("Please input your UserName");
		userName = sc.nextLine();
		System.out.println("Please input your PassWord");
		passWord = sc.nextLine();
		System.out.println(userName);
		return ver.checkIDandPsw(userName, passWord);
		
		
	}
	public void putSessions() {
		/**
		 * p1- p7 is instance of adult storage in listAdult
		 */
		Session s1 = new Session(1, "Gone With the Wind  ", "11:00 am", "2 hours");
		Session s2 = new Session(2, "Jaws                ", "1:00 pm", "2 hours");
		Session s3 = new Session(3, "The Ten Commandments", "3:00 pm", "2 hours");
		Session s4 = new Session(4, "Doctor Zhivago      ", "5:00 pm", "2 hours");
		Session s5 = new Session(5, "The Sound of Music  ", "7:00 pm", "2 hours");

		/**
		 * p10 is instance of baby storage in listBaby
		 */

		listSession.add(s1);
		listSession.add(s2);
		listSession.add(s3);
		listSession.add(s4);
		listSession.add(s5);
	}

	// book a session
	public int bookID = 1;
	private Scanner sc;

	public void bookSession() {
		// int locationNo;

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
		email = sc.nextLine();
		// locationNo = Integer.parseInt(locationStr);
		showAllSessions();
		System.out.println("Enter the session you want to book");
		sessionStr = sc.nextLine();
		sessionID = Integer.parseInt(sessionStr);
		Iterator<Session> it = listSession.iterator();//
		while (it.hasNext()) {
			Session s = it.next();
			if (sessionID == s.getSessionID()) {
				Booking b = new Booking(bookID, email, locationStr, s.getMovieName(), s.getTime(), s.getDuration());
				listBooking.add(b);
				bookID++;
			}
		}

	}

	// List all the sessions
	public void showAllSessions() {
		System.out.println("SessionID\t\t" + "MovieName\t\t" + "Time\t\t" + "Durations" + "\n");

		Iterator<Session> it = listSession.iterator();//
		while (it.hasNext()) {
			Session p = it.next();
			System.out.println(p.getSessionID() + "\t\t" + p.getMovieName() + "\t\t" + p.getTime() + "\t\t"
					+ p.getDuration() + "\t\t");
		}
	}

	//
	public void listAllBookings() {
		System.out.println(
				"BookingID\t\t" + "Email\t\t" + "Surburb\t\t" + "MovieName\t\t" + "Time\t\t" + "Durations" + "\n");

		Iterator<Booking> it = listBooking.iterator();//
		while (it.hasNext()) {
			Booking p = it.next();
			System.out.println(p.getBookingID() + "\t\t" + p.getEmail() + "\t\t" + p.getSurburb() + "\t\t"
					+ p.getMovieName() + "\t\t" + p.getTime() + "\t\t" + p.getDuration() + "\t\t");
		}
	}

	public void searchSession() {
		// OptionNoRegex reg=new OptionNoRegex();
		System.out.println("Enter the Movie name you want to search");
		Scanner sc = new Scanner(System.in);
		String movieName = sc.nextLine();
		// gender=reg.sexRegex(gender);
		Iterator<Session> it = listSession.iterator();// 
		while (it.hasNext()) {
			Session p = it.next();
			if (movieName.equals(p.getMovieName().trim())) 
			{
			    System.out.print(p.getMovieName()+ ""+ movieName);
				System.out.println(p.getSessionID() + "\t\t" + p.getMovieName() + "\t\t" + p.getTime() + "\t\t"
						+ p.getDuration() + "\t\t");
			}
		}
	}
	
	public void deleteBooking() {
			  System.out.println("Enter the ID  of the booking you want to delete：");
			  Scanner sc=new Scanner(System.in);
			  int bookingID=Integer.parseInt(sc.nextLine()); //
			  Iterator<Booking> it=listBooking.iterator();//
			  while(it.hasNext())
			  {
			   Booking p=it.next();
			    if(bookingID==p.getBookingID()){
			     listBooking.remove(p);
			     System.out.println("DeleteSuccess");
			    }
			    }
			  
			 
	}
}
