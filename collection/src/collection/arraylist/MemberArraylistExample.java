package collection.arraylist;

import collection.Member;

public class MemberArraylistExample {

	public static void main(String[] args) {
		MemberArraylist memberArraylist = new MemberArraylist();
		Member member1 = new Member(101, "Kim");
		Member member2 = new Member(102, "Mari");
		Member member3 = new Member(103, "Lee");
		memberArraylist.addMember(member1);
		memberArraylist.addMember(member2);
		memberArraylist.addMember(member3);
		
		memberArraylist.showMemberInfo();
		
		
		memberArraylist.removeMember(101);
		
		memberArraylist.showMemberInfo();
	}

}
