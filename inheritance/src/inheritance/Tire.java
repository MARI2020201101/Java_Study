package inheritance;

public class Tire {
	int maxRotation;
	int accumulateRotation;
	String Rotation;
	
	Tire(int maxRotaion, int accumulateRotation){
		this.maxRotation = maxRotaion;
		this.accumulateRotation =accumulateRotation;
	}
	
	boolean roll(){
		++accumulateRotation;
		if(maxRotation > accumulateRotation) {
			System.out.println("Left Rotation number : " + (maxRotation - accumulateRotation));
			return true;
		}
		else {
			stop();
			return false;
		}
		
	}
	void stop() {
		System.out.println("Stop the car");
	}
}
