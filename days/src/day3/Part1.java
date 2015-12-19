package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String up = "^";
		String left = "<";
		String down = "v";
		String right = ">";
		FileInputStream file = new FileInputStream(new File("res/day3/input.txt"));
		int x = 0;
		int y = 0;
		
		List<House> houses = new ArrayList<House>();
		houses.add(new House(x, y));
		while(file.available() > 0){
			String next = String.valueOf(Character.toChars(file.read())[0]);
			if(up.equals(next)){
				y++;
			}
			else if(down.equals(next)){
				y--;
			}
			else if(left.equals(next)){
				x--;
			}
			else if(right.equals(next)){
				x++;
			}
			addNewHouse(x, y, houses);
		}
		System.out.println(houses.size());
	}

	private static void addNewHouse(int x, int y, List<House> houses){
		House newHouse = new House(x, y);
		if(houses.contains(newHouse)){
			House house = houses.get(houses.indexOf(newHouse));
			house.addPresent();
		}
		else{
			houses.add(newHouse);
		}
	}

}
