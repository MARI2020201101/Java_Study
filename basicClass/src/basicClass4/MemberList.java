package basicClass4;

import java.util.ArrayList;


public class MemberList {
	ArrayList<Member> member = new ArrayList<Member>();
	
	public void addMember(Member member) {
		this.member.add(member);
	}
	
	/*public boolean removeMember(int memberID) {
		for(int i = 0 ; i < member.size() ; i++) {
			int tmp = member.get(i)
	
		if(memberID == member.getMemberID(i)) {
			member.remove(i);
			return true;
		}
	}return false;
	}*/

}
