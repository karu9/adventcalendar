package day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
	static List<String> voyels = new ArrayList<String>();
	static List<String> naugtyW = new ArrayList<String>();

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		voyels.add("a"); 
		voyels.add("e"); 
		voyels.add("i"); 
		voyels.add("o");  
		voyels.add("u");
		naugtyW.add("ab"); 
		naugtyW.add("cd"); 
		naugtyW.add("pq"); 
		naugtyW.add("xy");

		List<String> niceWords = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File("res/day5/input.txt"));
		
		String word = readWord(file);
		while(word != null && word.length() > 0){
			if(isNice(word)){
				niceWords.add(word);
			}
			word = readWord(file);
		}
		System.out.println(niceWords.size());
	}

	private static boolean isNice(String word) {
		return twoLettersRepeat(word) && hasSandwich(word);
	}

	private static boolean hasSandwich(String word) {
		for(int i = 0; i < word.length()-2; i++){
			if(word.substring(i, i+1).equals(word.substring(i+2, i+3))){
				return true;
			}
		}
		return false;
	}

	private static boolean twoLettersRepeat(String word) {
		for(int i = 0; i < word.length()-2; i++){
			for(int j = i+2; j < word.length() - 1; j++){				
				if(word.substring(i, i+2).equals(word.substring(j, j+2))){
					return true;
				}
			}
		}
		return false;
	}

	private static String readWord(FileInputStream file) throws IOException {
		if(file.available() > 0){
			String word = "";
			String charac = String.valueOf(Character.toChars(file.read())[0]);
			while(!"\n".equals(charac)){
				word += charac;
				charac = String.valueOf(Character.toChars(file.read())[0]);
			}
			return word;
		}
		else{
			return null;
		}
	}
}
