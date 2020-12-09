package stream;

import java.util.Arrays;

public class IntListExample {

	public static void main(String[] args) {
		int[] list = {1,2,3,4,5};
		int listsum = Arrays.stream(list).sum();
		System.out.println(listsum);
	}

}
