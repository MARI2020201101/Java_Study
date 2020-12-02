package singleton;

public class Company {
	
	private static Company companyA = new Company();
	private Company() {
		
	}
	public static Company getCompany() {
		return companyA;
	}

}
