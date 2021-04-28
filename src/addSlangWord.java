import java.util.Scanner;


public class addSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	public void add() {
		String SlangWord;	
		String Definition;
		String input;
            try {
            	do {
            		System.out.print("What is your new SlangWord: ");
                	SlangWord = scanner.nextLine();
                	System.out.print("What is your new Definition: ");
                	Definition = scanner.nextLine();
                	if(SlangWord.isEmpty() || Definition.isEmpty()) {
                		System.out.println("Please input !");
                	}
            	}while(SlangWord.isEmpty() || Definition.isEmpty());
            	if(slangword.checkSlang(SlangWord)) {
            		System.out.print("Slang allready exists. Do you want Overwrite or Dupilicate ? Please 1: Overwrite or 2: Dupilicate: ");
            		input = scanner.nextLine();
            		if(input == "1") {
            			slangword.addOverwrite(SlangWord, Definition);
            			System.out.println("Done");
            		}else {
            			slangword.addDuplicate(SlangWord, Definition);
            			System.out.println("Done");
            		}
            	}else {
            		slangword.addNew(SlangWord, Definition);
            		System.out.println("Done");
            	}
		
			}catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
