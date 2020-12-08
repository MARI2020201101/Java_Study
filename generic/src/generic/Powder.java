package generic;

public class Powder implements Material{

	@Override
	public void materialInfo() {
		System.out.println("Powder Material");
	}
	
	@Override
	public String toString() {
		return "Powder";
	}

}
