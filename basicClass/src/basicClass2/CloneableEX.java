package basicClass2;

class Circle{
	int x;
	int y;
	

	Circle(int x, int y) {
		this.x = x;
		this.y = y;
}


	@Override
	public String toString() {
		return "x = " + x + " , y =" + y;
	}
	
class CircleR {
	int radius;
	Circle circle;
	
	CircleR(int x, int y, int radius){
		circle = new Circle(x,y);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "x = " + x + " , y =" + y + " , radius : " + radius;
	}
	
	
}	
	
}

public class CloneableEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
