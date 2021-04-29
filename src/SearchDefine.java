import java.util.Scanner;

import slang.Exception;

public class SearchDefine {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	SearchSlangWord searchslangword = new SearchSlangWord();
	public String[][] S = null;
	public void show() {
		String word;	
		System.out.print("What word definition do want to find: ");
            try {
            	word = scanner.nextLine();
            	S = slangword.findDefinition(word);
        		if(S != null) {
        			for (int i = 0; i < S.length; i++) {
        				System.out.print("Result: ");
        				System.out.println(S[i][2]);
        				slangword.saveHistory(S[i][1], S[i][2]);
        			}
        		}
        		else {
        			System.out.println("Not found");
        		}
            } catch (Exception ex) {
                System.out.print("Exeption ! Please input retry ");
            }
        }
}
