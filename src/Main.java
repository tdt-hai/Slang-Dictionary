import java.util.*;

public class Main {
	public static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String choose = null;
          boolean exit = false;
          showMenu();
          while(true) {
        	  choose = scanner.nextLine();
        	  switch(choose) {
        	  case "1":
        		  System.out.println("Ban da chon cau 1");
        		  break;
        	  case "2":
        		  System.out.println("Ban da chon cau 2");
        		  break;
        	  case "3":
        		  System.out.println("Ban da chon cau 3");
        		  break;
        	  case "4":
        		  System.out.println("Ban da chon cau 4");
        		  break;
        	  case "5":
        		  System.out.println("Ban da chon cau 5");
        		  break;
        	  case "6":
        		  System.out.println("Ban da chon cau 6");
        		  break;
        	  case "7":
        		  System.out.println("Ban da chon cau 7");
        		  break;
        	  case "8":
        		  System.out.println("Ban da chon cau 8");
        		  break;
        	  case "9":
        		  System.out.println("Ban da chon cau 9");
        		  break;
        	  case "10":
        		  System.out.println("Ban da chon cau 10");
        		  break;
        	  case "11":
        		  System.out.println("Exit");
        		  exit=true;
        		  break;
        	  default:
        		  System.out.println("Not in list");
        		  break;
        	  }
        	  if(exit) {
            	  break;
              }
        	  showMenu();
          }
  }
	 public static void showMenu() {
         System.out.println("-----------MENU------------");
         System.out.println("1. Search by SlangWord.");
         System.out.println("2. Search by Definition.");
         System.out.println("3. Show history.");
         System.out.println("4. Add SlangWord.");
         System.out.println("5. Edit SlangWord.");
         System.out.println("6. Delete SlangWord.");
         System.out.println("7. Reset SlangWord to default.");
         System.out.println("8. Random SlangWord.");
         System.out.println("9. Minigame show random SlangWord.");
         System.out.println("10. Minigame show defitinion SlangWord.");
         System.out.println("11. EXITS.");
         System.out.println("---------------------------");
         System.out.print("YOUR CHOSE: ");
     }
    
}