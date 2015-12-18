package day10;

import java.io.IOException;
import java.util.ArrayList;

public class Part1D10 {
  public static void main(String[] args) throws IOException {
    String[] start = new String[]{"3","1", "1", "3", "3", "2", "2", "1", "1", "3"};
    for(int i = 0; i < 50; i++){
      start = tellNumber(start);
    }
    System.out.println(start.length);
  }

  public static String[] tellNumber(String[] number){
    ArrayList<String> numberTold = new ArrayList<String>();
    for(int i = 0; i < number.length;){
      if(i >= number.length){
        return numberTold.toArray(new String[numberTold.size()]);
      }
      if(i == number.length - 1){
        numberTold.add(String.valueOf(1));
        numberTold.add(number[i]);
        i++;
      }
      else if (i == number.length - 2){
        String sN = number[i];
        String cN = number[i+1];
        if(sN.equals(cN)){
          numberTold.add(String.valueOf(2));
          numberTold.add(sN);
        }
        else{

          numberTold.add(String.valueOf(1));
          numberTold.add(sN);
          numberTold.add(String.valueOf(1));
          numberTold.add(cN);
        }
        return numberTold.toArray(new String[numberTold.size()]);
      }
      else{
        int numberOfOccurence = 1;
        int k = i + 1;
        String sN = number[i];
        while (sN.equals(number[k])){
          numberOfOccurence++;
          k++;
        }

        numberTold.add(String.valueOf(numberOfOccurence));
        numberTold.add(String.valueOf(sN));
        i = k;
      }
    }
    return numberTold.toArray(new String[numberTold.size()]);
  }

}
