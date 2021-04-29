import java.util.Scanner;

public class DeleteSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	public void delete() {
		String word;	
		//String slang;
		System.out.print("What slang do want delete: ");
		try {
			word = scanner.nextLine();
        	slangword.delete(word);
        	
        } catch (Exception ex) {
            System.out.println("Not found");
        }
	}
}
