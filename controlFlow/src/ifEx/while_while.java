package ifEx;

public class while_while {

	public static void main(String[] args) {
		int dan = 2;
		int num = 1;
		while(dan<10) {
			num = 1;
			while(num<10) {
				System.out.println(dan + "*" + num + "=" + dan*num);
				num++;
			}
			dan++;
		}

	}

}
