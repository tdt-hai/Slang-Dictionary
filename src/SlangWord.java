import java.util.*;
import java.util.Map.Entry;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class SlangWord {
	
	private TreeMap<String, List<String>> map = new TreeMap<>();
	private static SlangWord obj = new SlangWord();
	private int sizeMap;
	private String FILE_SLANG = "slang.txt";
	private String FILE_SLANG_DEFAULT = "slang-default.txt";
	private String FILE_HISTORY = "history.txt";
	public SlangWord() {
		try {
			String current = new java.io.File(".").getCanonicalPath();
			FILE_SLANG = current + "\\" + FILE_SLANG;
			FILE_SLANG_DEFAULT = current + "\\" + FILE_SLANG_DEFAULT;
			FILE_HISTORY = current + "\\" + FILE_HISTORY;
			readFile(FILE_SLANG);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SlangWord getInstance() {
		if (obj == null) {
			synchronized (SlangWord.class) {
				if (obj == null) {
					obj = new SlangWord();
				}
			}
		}
		return obj;
	}

	void saveFile(String file) {
		try {
			PrintWriter printWriter = new PrintWriter(new File(file));
			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append("Slag`Meaning\n");
			String s[][] = new String[map.size()][3];
			Set<String> keySet = map.keySet();
			Object[] keyArray = keySet.toArray();
			for (int i = 0; i < map.size(); i++) {
				Integer in = i + 1;
				s[i][0] = in.toString();
				s[i][1] = (String) keyArray[i];
				List<String> meaning = map.get(keyArray[i]);
				stringBuilder.append(s[i][1] + "`" + meaning.get(0));
				for (int j = 1; j < meaning.size(); j++) {
					stringBuilder.append("|" + meaning.get(j));
				}
				stringBuilder.append("\n");
			}
			printWriter.write(stringBuilder.toString());
			printWriter.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void readFile(String file) throws Exception {
		map.clear();
		String slang = null;
		Scanner scanner = new Scanner(new File(file));
		scanner.useDelimiter("`");
		scanner.next();
		String temp = scanner.next();
		String[] part = temp.split("\n");
		int i = 0;
		int flag = 0;
		sizeMap = 0;
		while (scanner.hasNext()) {
			List<String> word = new ArrayList<String>();
			slang = part[1].trim();
			temp = scanner.next();
			part = temp.split("\n");
			if (map.containsKey(slang)) {
				word = map.get(slang);
			}
			if (part[0].contains("|")) {
				String[] d = (part[0]).split("\\|");
				for (int j = 0; j < d.length; j++)
				Collections.addAll(word, d);
				sizeMap += d.length - 1;
			} else {
				word.add(part[0]);
			}
			map.put(slang, word);
			i++;
			sizeMap++;
		}
		scanner.close();
	}

	public String[][] getData() {
		String s[][] = new String[sizeMap][3];
		Set<String> slagListSet = map.keySet();
		Object[] slagList = slagListSet.toArray();
		int index = 0;
		for (int i = 0; i < sizeMap; i++) {
			s[i][0] = String.valueOf(i);
			s[i][1] = (String) slagList[index];
			List<String> word = map.get(slagList[index]);
			s[i][2] = word.get(0);
			System.out.println(s[i][0] + "\t" + s[i][1] + "\t" + s[i][2]);
			for (int j = 1; j < word.size(); j++) {
				if (i < sizeMap)
					i++;
				s[i][0] = String.valueOf(i);
				s[i][1] = (String) slagList[index];
				s[i][2] = word.get(j);
				System.out.println(s[i][0] + "\t" + s[i][1] + "\t" + s[i][2]);
			}
			index++;
		}
		return s;
	}

	public String[][] getWord(String key) {
		List<String> listWord = map.get(key);
		if (listWord == null)
			return null;
		int size = listWord.size();
		String s[][] = new String[size][3];
		for (int i = 0; i < size; i++) {
			s[i][0] = String.valueOf(i);
			s[i][1] = key;
			s[i][2] = listWord.get(i);
		}
		return s;
	}

	public String[][] findDefinition(String query) {
		// Get all slang contain key
		List<String> keyList = new ArrayList<>();
		List<String> meaningList = new ArrayList<>();
		for (Entry<String, List<String>> entry : map.entrySet()) {
			List<String> meaning = entry.getValue();
			for (int i = 0; i < meaning.size(); i++) {
				if (meaning.get(i).toLowerCase().contains(query.toLowerCase())) {
					keyList.add(entry.getKey());
					meaningList.add(meaning.get(i));
				}
			}
		}
		int size = keyList.size();
		String s[][] = new String[size][3];

		for (int i = 0; i < size; i++) {
			s[i][0] = String.valueOf(i);
			s[i][1] = keyList.get(i);
			s[i][2] = meaningList.get(i);
		}
		return s;
	}
	public void update(String slang, String oldValue, String newValue) {
		List<String> meaning = map.get(slang);
		int index = meaning.indexOf(oldValue);
		meaning.set(index, newValue);
		this.saveFile(FILE_SLANG);
	}

	public void saveHistory(String slang, String word) throws Exception {
		// String file = "history.txt";
		File file1 = new File(FILE_HISTORY);
		FileWriter fr = new FileWriter(file1, true);
		fr.write(slang + "`" + word + "\n");
		fr.close();
	}

	public String[][] readHistory() {
		List<String> historySlag = new ArrayList<>();
		List<String> historyDefinition = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(FILE_HISTORY));
			scanner.useDelimiter("`");
			String temp = scanner.next();
			String[] part = scanner.next().split("\n");
			historySlag.add(temp);
			historyDefinition.add(part[0]);
			while (scanner.hasNext()) {
				temp = part[1];
				part = scanner.next().split("\n");
				historySlag.add(temp);
				historyDefinition.add(part[0]);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int size = historySlag.size();
		String s[][] = new String[size][3];
		for (int i = 0; i < size; i++) {
			s[size - i - 1][0] = String.valueOf(size - i);
			s[size - i - 1][1] = historySlag.get(i);
			s[size - i - 1][2] = historyDefinition.get(i);
		}
		return s;
	}


	public void reset() {
		try {
			readFile(FILE_SLANG_DEFAULT);
			this.saveFile(FILE_SLANG);
			System.out.println("Reset successfull");
		} catch (Exception e) {
			System.out.println("Reset fail: " + e);
		}
	}

	public void delete(String slang) {
		List<String> listMeaning = map.get(slang);
	    if (listMeaning == null) {
	    	System.out.println("Not found slangword");	    	
	    }
	    else {
	    	map.remove(slang);
	    	System.out.println("Done");
	    }
		sizeMap--;
		this.saveFile(FILE_SLANG);
	}

	public void addNew(String slang, String word) {
		List<String> meaningList = new ArrayList<>();
		meaningList.add(word);
		sizeMap++;
		map.put(slang, meaningList);
		this.saveFile(FILE_SLANG);
	}

	public void addDuplicate(String slang, String word) {
		List<String> meaningList = map.get(slang);
		meaningList.add(word);
		sizeMap++;
		map.put(slang, meaningList);
		this.saveFile(FILE_SLANG);
	}

	public void addOverwrite(String slang, String word) {
		List<String> meaningList = map.get(slang);
		meaningList.set(0, word);
		map.put(slang, meaningList);
		this.saveFile(FILE_SLANG);
	}

	public boolean checkSlang(String slang) {
		for (String keyIro : map.keySet()) {
			if (keyIro.equals(slang))
				return true;
		}
		return false;
	}

	public String[] random() {
		int minimum = 0;
		int maximum = map.size() - 1;
		int rand = randInt(minimum, maximum);
		// Get slang meaning
		String s[] = new String[2];
		int index = 0;
		for (String key : map.keySet()) {
			if (index == rand) {
				s[0] = key;
				s[1] = map.get(key).get(0);
				break;
			}
			index++;
		}
		return s;
	}

	public static int randInt(int minimum, int maximum) {
		return (minimum + (int) (Math.random() * maximum));
	}
    public String[] quizRandomSlangWord() {
    	String s[] = new String[6]; 
    	String[] slangRandom = this.random();
    	s[0] = slangRandom[0];
    	int rand = randInt(1, 4);
    	s[rand] = slangRandom[1];
    	s[5] = slangRandom[1];
    		for (int i = 1; i <= 4; i++) {
    		    if (rand == i)
    				continue;
    			else {
    			    String[] slangRand = this.random();
    				while (slangRand[0] == s[0]) {
    				      slangRand = this.random();
    			     }
    			   s[i] = slangRand[1];
    	        }
           }
    		return s;
     }
	public String[] quizDefineSlangWord() {
		String s[] = new String[6]; 
			String[] slangRandom = this.random();
			s[0] = slangRandom[1];
			int rand = randInt(1, 4);
			s[rand] = slangRandom[0];
			s[5] = slangRandom[0];
			for (int i = 1; i <= 4; i++) {
				if (rand == i)
					continue;
				else {
					String[] slangRand = this.random();
					while (slangRand[0] == s[0]) {
						slangRand = this.random();
					}
					s[i] = slangRand[0];
				}
			}
			return s; 
	}

}
