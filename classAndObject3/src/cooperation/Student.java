package cooperation;

public class Student {
	String studentName;
	int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		money -= 1000;
	}	
	public void takeSubway(Subway subway) {
		subway.take2(1250);
		money -= 1250;
	
		
	}
	public void studentInfo() {
		System.out.println(studentName + "의 남은 돈은" + money + "입니다.");
	}

}
