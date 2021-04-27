import java.util.*;

import slang.String;


public class SearchSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	public String[][] S = null;
	
	public void showElement(String word) {
		S = slangword.getMeaning(word);
		for (int i = 0; i < S.length; i++) {
			System.out.print("Result: ");
			System.out.println(S[i][2]);
		}
		
	}
	public void show() {
		String word;	
		System.out.print("What word do want to find: ");
		while (true) {
            try {
            	word = scanner.nextLine();
            	S = slangword.getMeaning(word);
            	long startTime = System.currentTimeMillis();
        		long endTime = System.currentTimeMillis();
        		long timeElapsed = endTime - startTime;
        		if(S == null) {
        			System.out.println("Not found");
        		}
        		else {
        	       showElement(word);
        		   System.out.printf(" ,Time in milisecond %s ms",String.valueOf(timeElapsed));
        		}
            } catch (NumberFormatException ex) {
                System.out.print("Exeption ! Please input retry ");
            }
        }
		
	}

}
