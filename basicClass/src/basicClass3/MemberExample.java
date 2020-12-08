package basicClass3;


public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member();
		
		member.setMemberID("n1");
		member.setMemberID("n2");
		member.setMemberID("n3");
		
		member.getMemberID();
		System.out.println("------------");
		
		member.removeMemberID("n2");
		member.getMemberID();
		System.out.println("------------");
		
		member.setMemberID("m1");
		member.showmemberID();
		System.out.println("------------");
		
		

	}

}
