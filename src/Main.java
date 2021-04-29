import java.util.*;

public class Main {
	public static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String choose = null;
          boolean exit = false;
          SlangWord slangword  = new SlangWord();
          SearchSlangWord searchSlangWord = new SearchSlangWord();
          SearchDefine searchdefine = new SearchDefine();
          ShowHistory showhistory = new ShowHistory();
          addSlangWord addslangword = new addSlangWord();
          editSlangWord editslangword = new editSlangWord();
          DeleteSlangWord deleteslangword = new DeleteSlangWord();
          showMenu();
          while(true) {
        	  choose = scanner.nextLine();
        	  switch(choose) {
        	  case "1":
        		  searchSlangWord.show();
        		  break;
        	  case "2":
        		  searchdefine.show();
        		  break;
        	  case "3":
        		  showhistory.show();
        		  break;
        	  case "4":
        		  addslangword.add();
        		  break;
        	  case "5":
        		  editslangword.edit();
        		  break;
        	  case "6":
        		  deleteslangword.delete();
        		  break;
        	  case "7":
        		  slangword.reset();
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
