package generic;

public class Plastic implements Material {

	@Override
	public void materialInfo() {
		System.out.println("Plastic Material");
	}

	@Override
	public String toString() {
		return "Plastic";
	}

}
