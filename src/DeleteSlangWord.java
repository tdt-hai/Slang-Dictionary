import java.util.Scanner;

public class DeleteSlangWord {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = new SlangWord();
	public void delete() {
		String word;	
		System.out.print("What slang do want delete: ");
		word = scanner.nextLine();
		try {
        	slangword.delete(word);
        	
        } catch (Exception ex) {
            System.out.print("Exeption ! Please input retry ");
        }
	}
}
