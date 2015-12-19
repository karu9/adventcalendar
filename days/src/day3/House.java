package day3;

public class House {
	public Integer x;
	public Integer y;
	public int numberOfPresent;
	
	public House(Integer x, Integer y){
		numberOfPresent = 1;
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof House){
			if (this.x.equals(((House) o).x) && this.y.equals(((House) o).y)){
				return true;
			}
		}
		return false;
	}
	
	public void addPresent(){
		numberOfPresent++;
	}
	
	public int getNumberOfPresents(){
		return numberOfPresent;
	}
}
