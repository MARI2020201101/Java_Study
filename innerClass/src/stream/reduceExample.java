package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class compareString implements BinaryOperator<String>{
	
	public String apply(String s1, String s2) {
		if(s1.getBytes().length < s2.getBytes().length)
			return s1;
		else return s2;
		
	}
	
	
}

public class reduceExample {

	public static void main(String[] args) {
		String[] list = {"Hello" , "my name", "is", "mari"};
		String i = Arrays.stream(list).reduce("", (s1, s2) ->{
									if(s1.getBytes().length > s2.getBytes().length)
										return s1;
									else return s2;}
		);
		System.out.println(i);

		String s = Arrays.stream(list).reduce(new compareString()).get();
		System.out.println(s);
		
	}


	

}
