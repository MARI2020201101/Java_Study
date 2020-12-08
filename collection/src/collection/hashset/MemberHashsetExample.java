package collection.hashset;


import collection.Member;

public class MemberHashsetExample {

	public static void main(String[] args) {
		MemberHashset memberHashset = new MemberHashset();
		Member member1 = new Member(201, "Tanaka");
		Member member2 = new Member(202, "Masa");
		Member member3 = new Member(203, "Nina");
		memberHashset.addMember(member1);
		memberHashset.addMember(member2);
		memberHashset.addMember(member3);
		
		memberHashset.showMemberInfo();
		
		Member member4 = new Member(203, "Momo");
		memberHashset.addMember(member4);
		
		memberHashset.showMemberInfo();
	}

}
