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
		System.out.println(Subwayline + "호선 지하철의 수입이 " + fee + "원 증가하였습니다.");
	}
	

}
