package day6;

public class Light {
    boolean lit;

    public Light(){
      lit = false;
    }

    private void toggle(){
      lit = !lit;
    }

    private void turnOn(){
      lit = true;
    }

    private void turnOff(){
      lit = false;
    }

    public void doAction(int action){
      if(action == 1){
        turnOn();
      }
      if(action == 0){
        turnOff();
      }
      else{
        toggle();
      }
    }

    public boolean isLit(){
      return lit;
    }

}
