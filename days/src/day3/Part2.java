package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

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
		int xSanta = 0;
		int ySanta = 0;
		int xRobot = 0;
		int yRobot = 0;
		int odd = 1;

		List<House> houses = new ArrayList<House>();
		houses.add(new House(xSanta, ySanta));
		while(file.available() > 0){
			String next = String.valueOf(Character.toChars(file.read())[0]);
			if(odd == 1){
				odd = 0;
				if(up.equals(next)){
					yRobot++;
				}
				else if(down.equals(next)){
					yRobot--;
				}
				else if(left.equals(next)){
					xRobot--;
				}
				else if(right.equals(next)){
					xRobot++;
				}
				addNewHouse(xRobot, yRobot, houses);
			}
			else{
				odd = 1;
				if(up.equals(next)){
					ySanta++;
				}
				else if(down.equals(next)){
					ySanta--;
				}
				else if(left.equals(next)){
					xSanta--;
				}
				else if(right.equals(next)){
					xSanta++;
				}
				addNewHouse(xSanta, ySanta, houses);
			}
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
