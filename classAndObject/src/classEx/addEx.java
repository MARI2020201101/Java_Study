package classEx;

public class addEx {
	public int addSum(int a, int b) {
		return (a+b);
	}

	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 3;
		addEx sum = new addEx();
		int c = sum.addSum(num1, num2);
		
		System.out.println(c);
	}
}
