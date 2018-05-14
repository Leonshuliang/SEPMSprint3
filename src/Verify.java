
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Verify {
	// verify the option number
	private String uName;
	private String pWord;

	public int menuRegex(int min, int max) {
		String regex = "[0-9]{1}";// menu is only one-digit between 1-9
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.matches(regex)) {
				int key = Integer.parseInt(input);
				if (key >= min && key <= max) {
					return key;
				} else {
					System.out.println("The number you are entering is uncorrect!");
				}
			} else {
				System.out.println("Please input a number!");
			}
		}

	}

	// verify name
	@SuppressWarnings("resource")
	public String nameRegex(String name) {
		// String pattern = "[A-Za-z]+";// all letters include capital A_Z and lower a-z
		String pattern = "^[ A-Za-z]*$";
		String str = name;
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (str.matches(pattern)) {
				return str;
			} else {
				System.out.println("Please enput again");
				str = sc.nextLine();
				continue;
			}
		}
	}

	// verify number
	// keep number between 0-99
	public String numberCheck(String age) {
		String pattern = "^([0-9]|[0-9]{2}|100)$";// only between 0-99 is valid
		String str = age;
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (str.matches(pattern)) {
				return str;
			} else {
				System.out.println("Invalid enput,Please enter again");
				str = sc.nextLine();
				continue;
			}
		}
	}

	// verify of email
	// keep email has the format with XXX@XXX.COM
	public String emailRegex(String email) {
		String pattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";// F is female M is male
		// String pattern ="^([0-9]|[0-9]{2}|100)$";//only between 0-99 is valid
		String str = email;
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (str.matches(pattern)) {
				return str;
			} else {
				System.out.println("Invalid enput,Please enter again");
				str = sc.nextLine();
				continue;
			}
		}
	}

	// check if can find file in system.
	public void readFile() {

		File file = new File("./src/user.txt");
		if (file.exists() == false) {
			System.out.println("cannot find file");
			return;
		}
		try {
			// creat filereader to read file
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String lineText;
			// put context in string
			lineText = br.readLine();
			while (lineText != null) {
				creatInfo(lineText);
				lineText = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// get information from file
	public void creatInfo(String text)

	{
		if (text == null)
			return;
		if ("".equals(text))
			return;

		String[] pswdUsername = text.split(" ");
		// make sure there are password and username in string[]
		if (pswdUsername == null || pswdUsername.length != 2) {
			System.out.println("Please check content form in your file");
			return;
		} else {
			uName = pswdUsername[0];
			pWord = pswdUsername[1];
		}
	}

	// this method will be called by main method to start the system.
	public void startPage() {
		Driver driver = new Driver();
		Menu m = new Menu();
		// put all sessions in jMoSS
		try {
			driver.putSessions();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			m.mainMenu();
			int key = menuRegex(1, 7);

			switch (key) {
			case 1:
				driver.bookSession();// show all the people in this social net
				break;
			case 2:
				driver.showAllSessions();// show all sessions in cinemas
				break;
			case 3:
				driver.searchSession();// search a session by name
				break;
			case 4:
				driver.deleteBooking();// add a person
				break;
			case 5:
				driver.listAllBookings();// list all bookings
				break;
			case 6:
				driver.searchBooking();// list all bookings
				break;
			case 7:
				// System.exit(0);// exit this system
				driver.exitSystem();
				System.exit(0);
				break;

			}
		}

	}

	// after
	public void checkIDandPsw() {
		// read password and user name from file
		readFile();
		// start to check ID information
		String userName;
		String passWord;
		Scanner sc = new Scanner(System.in);

		// System.out.println(userName);

		boolean b = false;
		for (int i = 0; i < 3; i++) {
			System.out.println("*******************************************************\n"
					+ "******************Welcome to jMoSS !! *****************\n"
					+ "**********Please enter your identity information*******\n"
					+ "*******************************************************");
			System.out.println("=======================================================");
			System.out.println("===========Please input your UserName==================");
			userName = sc.nextLine();
			System.out.println("===========Please input your PassWord==================");
			passWord = sc.nextLine();

			if (uName.equals(userName) && pWord.equals(passWord)) {
				b = true;
				startPage();
				break;
			}
			System.out.println("*************Incorect UserName or PassWord please input Again***************");

		}
		if (!b) {
			System.out.println("---------MAXIMUM INPUT!!!!---------");
			System.exit(0);
		}
	}
}
