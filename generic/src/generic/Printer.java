package generic;

public class Printer<T> {
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	public void printInfo() {
		System.out.println("Printer with " + material);
	}

}
