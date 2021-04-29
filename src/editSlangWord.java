import java.util.Scanner;

public class editSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	public String[][] S = null;
	SlangWord slangword = new SlangWord();
	public void edit() {
		String word;	
		String newValue;
		System.out.print("What slang do want to edit: ");
		 try {
         	word = scanner.nextLine();
         	S = slangword.getWord(word);
         	if(S != null) {
    			for (int i = 0; i < S.length; i++) {
    				System.out.print("Result: " + S[i][2]);
    			}
    			System.out.print("Do want to edit: ");
    			newValue = scanner.nextLine();
    			slangword.update(word,S[0][2], newValue);
    			System.out.println("Update done");
    		}
    		else {
    			System.out.println("Not found");
    		}
         } catch (Exception ex) {
             System.out.print("Error: "+ex);
         }
	}
}
