package array;

public class LotsofArray {

	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
	for(int i = 0 ; i < arr.length ; i++) {
		for(int j = 0 ; j <arr[i].length ; j++) {
			System.out.println(arr[i][j]);
		}
		
	}
	System.out.println("--------");
	
	int[][] arr2 = new int[3][3];
	
	
	System.arraycopy(arr, 0, arr2, 0, arr.length);
	for(int i = 0 ; i < arr2.length ; i++) {
		for(int j = 0 ; j <arr2[i].length ; j++) {
			System.out.println(arr2[i][j]);
		}
		
	}
	
	
	String[] study = new String[3];
	study[0] = "java";
	study[1] = "java";
	study[2] = new String("java");
	
	System.out.println(study[0]);
	System.out.println(study[0]==study[1]);
	System.out.println(study[0]==study[2]);
	System.out.println(study[0]==study[2]);
	
	}

}
