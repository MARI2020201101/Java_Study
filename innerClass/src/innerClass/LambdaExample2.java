package innerClass;

public class LambdaExample2 {

	public static void main(String[] args) {
		Lambda addEx = (x, y) -> x + y;
		int result = addEx.add(10, 20);
		System.out.println(result);
		
	
		
		LamdaExample aaa = new LamdaExample();
		int resul = aaa.add(1, 2);
		System.out.println(resul);
		
		Lambda adds = new Lambda() {
			
			@Override
			public int add(int x, int y) {
				
				return x + y;
			}
		};
		int ddd = adds.add(3, 4);
		System.out.println(ddd);
		
		
		
		
	}
	
	public int adds2(Lambda adds) {
		int tmp = adds.add(1, 4);
		return tmp;
	}
	
	
}
