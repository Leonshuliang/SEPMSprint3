
public class jMoSS {
 public static void main(String[] args) 
 {
  Menu m=new Menu();
  Driver o=new Driver();
  Verify reg=new Verify();
  o.putSessions();
  while(true){
   m.mainMenu();
  
   int key=reg.menuRegex(1, 6);
   switch(key){
   case 1:
	   o.bookSession();//show all the people in this social net 
    break;
   case 2:
	   o.showAllSessions();
    break;
//   case 3:
//    
//    break;
//   case 4:
//	   o.addPerson();//add a person 
//    break;
   case 5:
	  o.listAllBookings();//
//    break;
//   case 6:
//	   o.deleteLogic();//delete a person by attribute
//	    break;

   }
  }
 }
}