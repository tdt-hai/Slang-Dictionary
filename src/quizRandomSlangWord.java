import java.util.Scanner;

public class quizRandomSlangWord {
    SlangWord slangword = new SlangWord();
    public static Scanner scanner = new Scanner(System.in);
    String S[] = null;
    String answer;
    public void quiz() {
    	String array[] = {"A","B","C","D"};
    	S = slangword.quizRandomSlangWord();
    	System.out.println("What does this " +S[0]+" mean ?");
    	System.out.println(array[0]+". "+S[1]);
    	System.out.println(array[1]+". "+S[2]);
    	System.out.println(array[2]+". "+S[3]);
    	System.out.println(array[3]+". "+S[4]);
    	System.out.print("Your answer: ");
   	    answer = scanner.nextLine();
    	if (S[1].equals(S[5]) && answer.equals(array[0])) {
		   System.out.println("Your correct");
		} else if (S[2].equals(S[5]) && answer.equals(array[1])) {
			System.out.println("Your correct");
		} else if(S[3].equals(S[5]) && answer.equals(array[2])) {
			System.out.println("Your correct");
		}else if(S[4].equals(S[5]) && answer.equals(array[3])) {
			System.out.println("Your correct");
		}else {
			System.out.println("Your wrong");
		}
    }
}
