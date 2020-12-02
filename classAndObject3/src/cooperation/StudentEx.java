package cooperation;

public class StudentEx {

	public static void main(String[] args) {
		Student mari = new Student("mari",5000);
		Bus seoul = new Bus("237bus",1000);
		
		mari.takeBus(seoul);
		mari.studentInfo();
		seoul.busInfo();

		Student nina = new Student("nina", 10000);
		Subway pusan = new Subway(2,1250);
		
		nina.takeSubway(pusan);
		nina.studentInfo();
		pusan.subwayInfo();
	}

}
