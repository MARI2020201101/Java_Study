package api;

import java.util.Scanner;

public class scanner2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		System.out.println(str);
		
		Scanner scanfile = new Scanner("scanthis.txt");
		String str2 = scanfile.nextLine();
		System.out.println(str2);

	}

}
