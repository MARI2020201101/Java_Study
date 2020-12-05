package method;

public class Car {
	//property
	int gas;
	//constructor
	
	//method
	void setGas(int gas){
		this.gas = gas;
	}
	boolean isGas(){
		boolean result = false;
		if(gas != 0) {	
			result = true;
		}
		else {}
		return result;
		
	}
	void run(){
		System.out.println("Let's Go!");
		while(gas>0) {
			System.out.println("i have gas : " + gas);
			gas--;
		}
		
		
	}

}
