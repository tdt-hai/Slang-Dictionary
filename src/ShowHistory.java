import java.util.Scanner;


public class ShowHistory {
	public static Scanner scanner = new Scanner(System.in);
	SlangWord slangword = SlangWord.getInstance();
	public String[][] S = null;
	public void show() {
	    S = slangword.readHistory();
	    System.out.println("STT" +"   "+"Slang"+"   "+"Word");
		for(int i = 0 ; i < S.length ;i++) {
			System.out.print(S[i][0]+"      "+S[i][1]+"      "+S[i][2]);
			System.out.println();
		}
	}
}
