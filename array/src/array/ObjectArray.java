package array;

public class ObjectArray {

	public static void main(String[] args) {
		String[] arr = {"java", "very", "fun"};
		
		for(String java : arr) {
			System.out.println(java);
		}
		
		int[][] arr2 = {{10,20,30},{40,50,60}};
		for(int i = 0 ; i < arr2.length ; i++) {
			for(int j = 0 ; j <arr2[i].length ; j++) {
				System.out.println(arr2[i][j]);
			}
		
		}
		
		String[][] arr3 = {{"a","b","c"},{"d","e","f"}};
		for (int i = 0 ; i <arr3.length ; i++) {
		for(int j = 0 ; j <arr3[i].length ; j++) {
			System.out.println(arr3[i][j]);
		}}
		int allsum = 0;
		int[] score = {90,67,80};
		for(int sum : score) {
			allsum += sum;
		}
		System.out.println(allsum);
		double avg = allsum / score.length;
		System.out.println(avg);
		
	}
}


	


