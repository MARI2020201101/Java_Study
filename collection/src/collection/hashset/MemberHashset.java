package collection.hashset;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

public class MemberHashset {
	private HashSet<Member> memberHashSet;
	
	public MemberHashset() {
		 memberHashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member) {
		memberHashSet.add(member);
	}

	public boolean removeMember(int memberID) {
		Iterator<Member> ir = memberHashSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tmp = member.getMemberID();
			if(tmp == memberID) {
				memberHashSet.remove(member);
				return true;
			}
		}return false;
		
	}
	
	public void showMemberInfo() {
		/*Iterator<Member> ir = memberHashSet.iterator();
		while(ir.hasNext()) {
			ir.next();
			Member member = (Member)ir;
			System.out.println(member);
		}*/
		
		System.out.println(memberHashSet);
	}
}
