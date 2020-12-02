package singleton;

public class CompanyeEx {

	public static void main(String[] args) {
		Company c1 = Company.getCompany();
		Company c2 = Company.getCompany();
		
		System.out.println(c1);
		System.out.println(c2);

	}

}
