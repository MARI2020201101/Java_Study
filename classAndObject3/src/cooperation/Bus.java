package cooperation;

public class Bus {
	String busName;
	int passengers;
	int fee;
	
	public Bus(String busName, int fee) {
		this.busName = busName;
		this.fee = fee;
	}
	public void take(int fee) {
		fee += fee;
		passengers++;
	}
	public void busInfo() {
		System.out.println(busName + "�� ������" + fee + "�� �����Ͽ����ϴ�.");
	}
}
