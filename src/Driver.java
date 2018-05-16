
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver {

	private List<String[]> listSession = new ArrayList<String[]>();
	private List<Booking> listBooking = new ArrayList<Booking>();
	private Verify verify = null;
	FileReader reader = null;

	public void putSessions() throws FileNotFoundException {
		/**
		 * s1-s5 are instance session
		 */

		try {
			reader = new FileReader("./src/Session.txt");
			BufferedReader br = new BufferedReader(reader);

			String eachLine = null;
			while ((eachLine = br.readLine()) != null) {

				String[] temp = eachLine.split(",");
				/**
				 * put all sessions in session list
				 */
				listSession.add(temp);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// book a session
	public int bookID = 1;
	private Scanner sc;

	public void bookSession() {

		int sessionID; // ID of session stored in list
		String locationStr;// cinema location
		String email, conFirm;// customers email and booking confirmation message

		Menu m = new Menu();// instance of menu
		verify = new Verify();
		/*
		 * get all information to add a booking emial and id all have regex to check if
		 * they are valid
		 */
		locationMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the location you want to book");
		locationStr = sc.nextLine();
		// location only can be English letters
		locationStr = verify.nameRegex(locationStr);
		System.out.println("Enter custom's email");
		email = sc.nextLine();
		// check email is valid or not emial must be XXX@XXX.XXX
		email = verify.emailRegex(email);
		showAllSessions();
		System.out.println("Enter the session ID you want to book");
		sessionID = verify.menuRegex(1, 5);

		System.out.println("*******Confirm to make this booking*********" + "\n" + "*******enter'Y'--YES*********\n"
				+ "*******enter'N'--NO**********");
		conFirm = sc.nextLine();

		if (conFirm.equals("Y")) {
			Iterator<String[]> it = listSession.iterator();// interator of session list

			while (it.hasNext()) {

				String[] s = it.next();
				if (sessionID == Integer.parseInt(s[0])) {
					Booking b = new Booking(bookID, email, locationStr, s[1], s[2], s[3]);
					listBooking.add(b);
					System.out.println("***********Booking successful************");
					bookID++;
					break;
				}
			}
			putIntoFile();
		}

	}

	// write all bookings into file
	public void putIntoFile() {
		// find file booking
		File writename = new File("./src/booking.txt");
		BufferedWriter out = null;

		try {
			writename.createNewFile();
			// if without this file, jMoSS will creat a new file named as booking
			out = new BufferedWriter(new FileWriter(writename, true));
			Iterator<Booking> it = listBooking.iterator();
			while (it.hasNext()) {
				Booking p = it.next();
				// write all informations in list into file
				out.write(p.getBookingID() + "," + p.getEmail() + "," + p.getSurburb() + "," + p.getMovieName() + ","
						+ p.getTime() + "," + p.getDuration() + "\n");
				out.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// List all the sessions
	public void showAllSessions() {
		System.out.println("SessionID\t\t" + "MovieName\t\t" + "Time\t\t" + "Durations" + "\n");

		Iterator<String[]> it = listSession.iterator();//
		while (it.hasNext()) {
			// Session p = it.next();
			String[] s = it.next();
			System.out.println(s[0] + "\t\t" + s[1] + "\t\t" + s[2] + "\t\t" + s[3] + "\t\t");
		}
	}

	// List all the bookings if without any booking still list the titles
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

	/*
	 * *search a booking by name if there is not any booking in systerm will get
	 * reminder
	 */
	public void searchBooking() {
		int sizeBooking = listBooking.size();
		verify = new Verify();
		if (sizeBooking < 1) {
			System.out.println("**************You have no any booking yet.*********************\n");

		} else {
			System.out.println("*******************************************************\n"
					+ "**********Enter the EMail you want to search***********\n"
					+ "*******************************************************");
			Scanner sc = new Scanner(System.in);
			String bookingEmail = sc.nextLine();
			bookingEmail = verify.emailRegex(bookingEmail);
			// interaator of booking list
			Iterator<Booking> it = listBooking.iterator();//
			while (it.hasNext()) {
				Booking p = it.next();
				if (bookingEmail.equals(p.getEmail().trim())) {
					System.out.println("BookingID\t\t" + "Email\t\t" + "Surburb\t\t" + "MovieName\t\t" + "Time\t\t"
							+ "Durations" + "\n");
					System.out.println(p.getBookingID() + "\t\t" + p.getEmail() + "\t\t" + p.getMovieName() + "\t\t"
							+ p.getTime() + "\t\t" + p.getDuration());
				}
			}
		}
	}

	// search a session by session name
	public void searchSession() {
		Verify verify = new Verify();
		int count = 0;
		System.out.println("*******************************************************\n"
				+ "**********Enter the movie name you want to search******\n"
				+ "*******************************************************");
		Scanner sc = new Scanner(System.in);
		String movieName = sc.nextLine();
		movieName = verify.nameRegex(movieName);// check the validation of movie name
		Iterator<String[]> it = listSession.iterator();// get iterator of the list of session
		while (it.hasNext()) {
			// Session p = it.next();
			String[] s = it.next();
			if (movieName.equalsIgnoreCase(s[1].trim())) {

				System.out.println("SessionID\t\t" + "MovieName\t\t" + "Time\t\t" + "Durations" + "\n");
				System.out.println(s[0] + "\t\t" + s[1] + "\t\t" + s[2] + "\t\t" + s[3] + "\t\t");
				count = 1;
			}

		}
		if (count == 0) {
			System.out.println("=============Cant find the movie you want to search===================");
			return;
		}
	}

	// delete a booking by booking ID, if whout anybookng will get message from this
	// systerm
	public void deleteBooking() {
		int sizeBooking = listBooking.size();
		if (sizeBooking < 1) {
			System.out.println("**************You have no any booking yet.*********************\n");

		} else {
			verify = new Verify();
			System.out.println("**************************************************************\n"
					+ "**********Enter the ID of the booking you want to delete******\n"
					+ "*************************************************************");

			Scanner sc = new Scanner(System.in);
			String bookingIDStr = sc.nextLine();
			verify.numberCheck(bookingIDStr);// check is it valid number or not
			int bookingID = Integer.parseInt(bookingIDStr);// get booking id
			System.out.println("*******Confirm to make this booking*********" + "\n" + "*******enter'Y'--YES*********\n"
					+ "*******enter'N'--NO**********");
			String conDel = sc.nextLine();

			if (conDel.equals("Y")) {
				Iterator<Booking> it = listBooking.iterator();// get iterator of booking list
				while (it.hasNext()) {
					Booking p = it.next();
					if (bookingID == p.getBookingID()) {
						listBooking.remove(p);

						System.out.println("-------------DeleteSuccess-----------------");
						break;
					}
				}
			} else if (conDel.equals("N")) {
				return;
			}

		}
	}

	// exit whole system
	public void exitSystem() {
		System.out.println("**************ARE YOU SURE YOU WANT TO LOG OUT*********************\n");
		System.out.println("*******Confirm to EXIT *********" + "\n" + "*******enter'Y'--YES*********\n"
				+ "*******enter'N'--NO**********");
		Scanner sc = new Scanner(System.in);
		String conFirm = sc.nextLine();
		conFirm = sc.nextLine();
		if (conFirm.equals("Y")) {
			System.out.println("******LOG OUT******\n");
			System.exit(0);

		}

	}

	public void locationMenu() {
		// FileReader reader = null;
		try {
			reader = new FileReader("./src/location.txt");
			BufferedReader br = new BufferedReader(reader);

			String eachLine = null;
			while ((eachLine = br.readLine()) != null) {

				System.out.println(eachLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
