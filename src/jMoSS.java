
public class jMoSS {
 public static void main(String[] args) 
 {
  Driver o=new Driver();
  Menu m=new Menu();
  Verify reg=new Verify();
  o.putSessions();
  if(o.inputInfo()==true) {
  while(true){
   m.mainMenu();
   int key=reg.menuRegex(1,6);
   
   switch(key)
   {
   case 1:
	   o.bookSession();//show all the people in this social net 
    break;
   case 2:
	   o.showAllSessions();
    break;
    case 3:
       o.searchSession();
    break;
   case 4:
	   o.deleteBooking();//add a person 
    break;
   case 5:
	  o.listAllBookings();//
    break;
   case 6:
	   System.exit(0);//exit this system
       break;

   }
  }
  }
  else {
	  System.out.print("Please check your information");
  }
 }
}