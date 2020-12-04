package array;

public class Array {

	public static void main(String[] args) {
		String[] arr;
		arr = new String[] {"a", "b", "c"};
		for(int i = 0; i < 3 ; i++) {
			System.out.println(arr[i]);
		}
		
		String[] arr2 = {"d", "e", "f"};
		for(int i = 0; i < arr2.length ; i++) {
			System.out.println(arr2[i]);
		}
		
		int[] arr3 = new int[3];
		arr3[0] = 100;
		arr3[1] = 90;
		arr3[2] = 80;
		int sum = 0;
		for (int i =0; i <arr3.length ; i++) {
			sum += arr3[i];
		}
		System.out.println(sum);
		double avg = (double)sum / arr3.length;
		System.out.println(avg);
		

	}

}
