package test;

import utils.Script;

public class Test {

	public void calTest() {
		int num =(int) Math.ceil(10/3*1.0);
		System.out.println("num is = "+ num);
	}
	public static void main(String[] args) {
		int num =(int) Math.ceil(10/(3*1.0));
		System.out.println("num is = "+ num);
		double num2 = Math.ceil(10/3*1.00);
		System.out.println("num2 is = "+ num2);
		System.out.println((10/3.0));
		
		String s = "2021-12-12 00:00:00";
		System.out.println(s.substring(0,10 ));
	
	}
}
