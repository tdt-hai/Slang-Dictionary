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
          randomSlangWord randomslangword = new randomSlangWord();
          quizRandomSlangWord quizrandom = new quizRandomSlangWord();
          quizDefineSlangWord quizdefine = new quizDefineSlangWord();
	      long startTime = System.currentTimeMillis();
	      long endTime = System.currentTimeMillis();
	  	  long timeElapsed = endTime - startTime;
  	   
          showMenu();
          while(true) {
        	  choose = scanner.nextLine();
        	  switch(choose) {
        	  case "1":
        		  searchSlangWord.show();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "2":
        		  searchdefine.show();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "3":
        		  showhistory.show();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "4":
        		  addslangword.add();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "5":
        		  editslangword.edit();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "6":
        		  deleteslangword.delete();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "7":
        		  slangword.reset();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "8":
        		  randomslangword.random();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		  break;
        	  case "9":
        		  quizrandom.quiz();
        		  break;
        	  case "10":
        		  quizdefine.quiz();
        		  System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
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
