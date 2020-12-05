package method;

public class CarExample {

	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.setGas(10);
		
		if(mycar.isGas()) {
			mycar.run();
		}
		

	}

}
