package method;

public class Calcul {
	
	//method
	int plus(int x, int y){
		int result;
		result = x + y;
		return result;
	}
	double avg(int x, int y) {
		double result = plus(x, y)/2;
		return result;
	}
	void execute() {
		
		double result = avg(5,7);
		System.out.println("result = " + result );
		
	}
	
}
