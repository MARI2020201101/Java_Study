package ifEx;

public class continue_Ex {

	public static void main(String[] args) {
		for(int sum = 0, num = 1; num < 11; num++) {
			if(num % 2 ==0) {
				sum += num;
			}
			else {
				continue;
			}
			System.out.println(sum);
		}

	}

}
