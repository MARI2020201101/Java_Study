package cooperation;

public class Subway {
	int Subwayline;
	int fee;
	
	public Subway(int Subwayline,int fee) {
		this.Subwayline = Subwayline;
		this.fee = fee;
	}
	public void take2(int fee) {
		fee += fee;
	}
	public void subwayInfo() {
		System.out.println(Subwayline + "ȣ�� ����ö�� ������ " + fee + "�� �����Ͽ����ϴ�.");
	}
	

}
