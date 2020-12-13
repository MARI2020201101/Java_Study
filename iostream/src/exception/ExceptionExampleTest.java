package exception;

public class ExceptionExampleTest {
	
	private String memberID;
	

	public String getMemberID() {
		return memberID;
	}


	public void setMemberID(String memberID) throws ExceptionExample {
		
		if(memberID.length() < 8 || memberID.length() > 20) {
			throw new ExceptionExample("memberID should be longer than 8 int and shorter than 20 int");
		}else
		this.memberID = memberID;
	}


	public static void main(String[] args) {
		
		ExceptionExampleTest eet = new ExceptionExampleTest();
		String m1 = "sfdf";
		try {
			eet.setMemberID(m1);
		} catch (ExceptionExample e) {
			System.out.println(e);
		}
		

	}

}
