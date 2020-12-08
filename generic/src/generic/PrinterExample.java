package generic;

public class PrinterExample {

	public static void main(String[] args) {
		Printer<Powder> myprinter = new Printer<Powder>();
		myprinter.setMaterial(new Powder());
		myprinter.printInfo();
		Powder p = myprinter.getMaterial();
		System.out.println(p);
		
		Printer<Plastic> myprinter2 = new Printer<Plastic>();
		myprinter2.setMaterial(new Plastic());
		myprinter2.printInfo();
		
		

	}

}
