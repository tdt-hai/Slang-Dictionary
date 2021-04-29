
public class randomSlangWord {
	SlangWord slangword = new SlangWord();
	public String S[] = null;
	public void random() {
		S = slangword.random();
		System.out.println("Slang: " + S[0]+"  "+"Word: " + S[1]);
	}
}
