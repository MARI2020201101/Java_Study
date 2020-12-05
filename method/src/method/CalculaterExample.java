package method;

public class CalculaterExample {

	public static void main(String[] args) {
		Calculator mycalc = new Calculator();
		int[] sumlist = {1,2,3,4,5};
		int result1 = mycalc.sum(sumlist);
		System.out.println(result1);
		
		
		Calculator mycalc2 = new Calculator();
		int result2 = mycalc2.sum(new int[]{1,2,3,4});
		System.out.println(result2);
		
		
		Calculator mycalc3 = new Calculator();
		int result3 = mycalc3.sum2(1,2,3);
		System.out.println(result3);

	}

	
}
