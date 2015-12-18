package day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


public class Part1D6 {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    HashMap<Integer, HashMap<Integer, Light>> lights = initiateLights();
    FileInputStream file = new FileInputStream(new File("res/day6/input.txt"));
    String word = readWord(file);
    int numberofInstructions = 0;
    while (word != null && word.length() > 0){
      execInstructions(word, lights);
      numberofInstructions ++;
      word = readWord(file);
    }
    System.out.println(numberofInstructions);
    System.out.println(countLitLights(lights));
  }

  private static int countLitLights(HashMap<Integer, HashMap<Integer, Light>> lights) {
    int lightCount = 0;
    for(int i = 0; i < 1000; i++){
      for (int j = 0; j < 1000; j++){
        Light light = lights.get(i).get(j);
        if(light.isLit()){
          lightCount++;
        }
      }
    }
    return lightCount;
  }

  private static void execInstructions(String word, HashMap<Integer, HashMap<Integer, Light>> lights) {
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
    executeAction(fromX, toX, fromY, toY, action, lights);
  }

  private static void executeAction(int fromX, int toX, int fromY, int toY, int action,
      HashMap<Integer, HashMap<Integer, Light>> lights) {
    for(int x = fromX; x <= toX; x++){
      for(int y = fromY; y <= toY; y++){
        lights.get(x).get(y).doAction(action);
      }
    }
  }

  public static HashMap<Integer, HashMap<Integer, Light>> initiateLights(){
    HashMap<Integer, HashMap<Integer, Light>> lights = new HashMap<Integer, HashMap<Integer,Light>>();
    for(int i = 0; i < 1000; i++){
      HashMap<Integer, Light> lightY = new HashMap<Integer, Light>();
      for (int j = 0; j < 1000; j++){
        lightY.put(j, new Light());
      }
      lights.put(i, lightY);
    }
    return lights;
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
