package ifEx;

public class if_example {

	public static void main(String[] args) {
		int age = 16;
		int money = 1000;
		if(age <= 15) {
			System.out.println("admission fee is " + money + ".");
		}
		else {
			money = 2000;
			System.out.println("admission fee is " + money + ".");
		}

	}

}
