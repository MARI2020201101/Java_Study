package collection.arraylist;

import java.util.ArrayList;
import collection.Member;

public class MemberArraylist {
	private ArrayList<Member> memberArrayList;
	
	public MemberArraylist() {
		 memberArrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		memberArrayList.add(member);
	}
	
	public boolean removeMember(int memberID) {
		for(int i = 0; i < memberArrayList.size() ; i++) {
			Member member = memberArrayList.get(i);
			int tmp = member.getMemberID();
			if(memberID == tmp) {
				memberArrayList.remove(i);
				return true;
			}
		}
		System.out.println(memberID + "Not Found");
		return false;
	}
	
	public void showMemberInfo() {
		for(Member member : memberArrayList) {
		System.out.println(member);
		}
		
	}

}
