package inheritance;

public class Car {
	Tire frontleftTire = new Tire(4,0);
	Tire frontrightTire = new Tire(2,0);
	Tire backleftTire = new Tire(3,0);
	Tire backrightTire = new Tire(5,0);
	
	int run() {
		if (frontleftTire.roll()==false) {
			frontleftTire.stop();
			return 1;
		}
		if (frontrightTire.roll()==false) {
			frontrightTire.stop();
			return 2;
		}
		if (backleftTire.roll()==false) {
			backleftTire.stop();
			return 3;
		}
		if(backrightTire.roll()==false) {
			backrightTire.stop();
			return 4;
		}
		return 0;
		
	}

}
