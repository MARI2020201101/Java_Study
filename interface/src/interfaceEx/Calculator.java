package interfaceEx;


public class Calculator implements Calc{
	
	
	

	@Override
	public int plus(int x, int y) {
		int result = 0;
		result = x + y;
		return result;
	}

	@Override
	public int minus(int x, int y) {
		int result = 0;
		result = x - y;
		return result;
	}

}
