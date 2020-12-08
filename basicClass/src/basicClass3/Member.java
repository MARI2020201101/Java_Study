package basicClass3;

import java.util.ArrayList;

public class Member {
	private ArrayList<String> memberID;
	
	public Member() {
		memberID = new ArrayList<String>();
		
	}

	public String getMemberID() {
		String str = null;
		for(String tmp : memberID) {
			System.out.println(tmp);
			str = tmp;
		}
		return str;
	}

	public void setMemberID(String memberID) {
		this.memberID.add(memberID);
	}

	public boolean removeMemberID(String str) {
		for(int i = 0; i < memberID.size() ; i++) {
			String memberIDex = memberID.get(i);
			if(memberIDex == str) {
				memberID.remove(i);
				return true;
			}
		}
		System.out.println("search fail");
		return false;
		
	}
	
	public void showmemberID() {
		for(String member : memberID) {
			System.out.println(member);
		}
	}
	
	

	
	
	
	

}
