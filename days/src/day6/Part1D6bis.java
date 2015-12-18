package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Part1D6bis {
  public static void main(String[] args) throws IOException {
    int[][] lights = initiateLights();

    BufferedReader b = new BufferedReader(new FileReader(new File("res/day6/input.txt")));
    String line = null;
    while ((line = b.readLine()) != null) {
      execInstructions(line, lights);
    }
    System.out.println(countLitLights(lights));
  }

  private static void execInstructions(String word, int[][] lights) {
    int action;
    if(word.indexOf("toggle") > -1){
      action = -1;
      word = word.substring(7, word.length());
    }
    else if(word.indexOf("turn off") > -1){
      action = 0;
      word = word.substring(9, word.length());
    }
    else{
      action = 1;
      word = word.substring(8, word.length());
    }
    int fromX = Integer.parseInt(word.split(" ")[0].split(",")[0].trim());
    int fromY = Integer.parseInt(word.split(" ")[0].split(",")[1].trim());
    int toX = Integer.parseInt(word.split(" ")[2].split(",")[0].trim());
    int toY = Integer.parseInt(word.split(" ")[2].split(",")[1].trim());
    for(int i = fromX; i <= toX; i++){
      for(int j = fromY; j <= toY; j++){
        if(action == -1){
          if(lights[i][j] == 0){
            lights[i][j] = 1;
          }
          else{
            lights[i][j] = 0;
          }
        }
        else{
          lights[i][j] = action;
        }
      }
    }
  }

  private static int[][] initiateLights() {
    int[][] lights = new int[1000][1000];
    for(int i = 0; i < 1000; i++){
      for (int j = 0; j < 1000; j++){
        lights[i][j] = 0;
      }
    }
    return lights;
  }

  private static int countLitLights(int[][] lights) {
    int lightCount = 0;
    for(int i = 0; i < 1000; i++){
      for (int j = 0; j < 1000; j++){
        if(lights[i][j] == 1){
          lightCount++;
        }
      }
    }
    return lightCount;
  }

  public static String readWord(FileInputStream file) throws IOException {
    if(file.available() > 0){
      String word = "";
      String charac = String.valueOf(Character.toChars(file.read())[0]);
      while(!"\n".equals(charac) && file.available() > 0){
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
