package inheritance;

public class KumhoTire extends Tire{
	
	KumhoTire(int maxRotation, int accumulateRotation){
		super(maxRotation,accumulateRotation);
	}

	boolean roll(){
		++accumulateRotation;
		if(maxRotation > accumulateRotation) {
			System.out.println("Left Kumho Rotation number : " + (maxRotation - accumulateRotation));
			return true;
		}
		else {
			stop();
			return false;
		}
		
	}
	void stop() {
		System.out.println("Kumho Stop the car");
	}
}
