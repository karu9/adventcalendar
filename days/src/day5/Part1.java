package day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
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
		return hasEnoughVoyels(word) && hasDoubleLetter(word) && !isNaughty(word);
	}

	private static boolean isNaughty(String word) {
		for(String nS : naugtyW){			
			if(word.indexOf(nS) > -1){
				return true;
			}
		}
		return false;
	}

	private static boolean hasDoubleLetter(String word) {
		for(int i = 0; i < word.length()-1; i++){
			if(word.substring(i, i+1).equals(word.substring(i+1, i+2))){
				return true;
			}
		}
		return false;
	}

	private static boolean hasEnoughVoyels(String word) {
		int voyelCount = 0;
		for(int i = 0; i < word.length(); i++){
			if(voyels.contains(word.substring(i, i+1))){
				voyelCount++;
			}
		}
		return voyelCount > 2;
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
