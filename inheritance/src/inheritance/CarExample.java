package inheritance;

public class CarExample {

	public static void main(String[] args) {
		Car mycar = new Car();
		
		for(int i = 0 ; i < 10 ;i++) {
		int rotationNum = mycar.run();
		switch(rotationNum) {
		case 1: 
			System.out.println("frontleftTire should be changed");
			mycar.frontleftTire = new KumhoTire(10,0);
			break;
		case 2: 
			System.out.println("frontrightTire should be changed");
			mycar.frontrightTire = new KumhoTire(11,0);
			break;
		case 3: 
			System.out.println("backleftTire should be changed");
			mycar.backleftTire = new KumhoTire(9,0);
			break;
		case 4: 
			System.out.println("backrightTire should be changed");
			mycar.backrightTire = new KumhoTire(12,0);
			break;
		}
		}

	}

}
