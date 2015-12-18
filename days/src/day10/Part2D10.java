package day10;

import java.io.IOException;
import java.util.Arrays;

public class Part2D10 {
  public static void main(String[] args) throws IOException {
    int[] start = new int[]{3,1,1,3,3,2,2,1,1,3};
    for(int i = 0; i < 50; i++){
      System.out.println(i);
      start = tellNumber(start);
    }
    System.out.println(start.length);
  }

  public static int[] tellNumber(int[] number){
    int[] numberTold = new int[0];
    int numberOfOcc = 1;
    int currNumber = number[0];
    for(int i = 1; i < number.length; i++){
      int nextNumber = number[i];
      if(nextNumber == currNumber){
        numberOfOcc++;
      }
      else{
        numberTold = addNumbers(numberTold, numberOfOcc, currNumber);
        numberOfOcc = 1;
        currNumber = nextNumber;
      }
    }
    return numberTold;
  }

  private static int[] addNumbers(int[] numberTold, int numberOfOcc, int currNumber) {
    int[] number = Arrays.copyOf(numberTold, numberTold.length +2);
    number[numberTold.length] = numberOfOcc;
    number[numberTold.length+1] = currNumber;
    numberTold = null;
    return number;
  }

}
