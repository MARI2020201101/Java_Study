package method;

public class Calculator {
	
	//method
	public int sum(int[] numlist) {
		int result = 0;
		for(int num : numlist) {
		result += num;
		}
		return result;
	}
	
	public int sum2(int ...values) {
		int result = 0;
		for(int value : values) {
			result += value;
		}
		return result;
		}
	}


