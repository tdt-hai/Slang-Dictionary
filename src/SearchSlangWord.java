import java.util.*;

import slang.String;


public class SearchSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	public String[][] S = null;
	
	public void show() {
		String word;	
		System.out.print("What word do want to find: ");
            try {
            	word = scanner.nextLine();
            	S = slangword.getMeaning(word);
            	long startTime = System.currentTimeMillis();
        		long endTime = System.currentTimeMillis();
        		long timeElapsed = endTime - startTime;
        		if(S != null) {
        			for (int i = 0; i < S.length; i++) {
        				System.out.print("Result: ");
        				System.out.println(S[i][2]);
        				slangword.saveHistory(S[i][1], S[i][2]);
        			}
         		   System.out.printf("Time in milisecond %s ms \n",String.valueOf(timeElapsed));
        		}
        		else {
        			System.out.println("Not found");
        		}
            } catch (Exception ex) {
                System.out.print("Exeption ! Please input retry ");
            }
        }
		
	}
