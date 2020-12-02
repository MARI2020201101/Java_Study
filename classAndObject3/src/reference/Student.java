package reference;

public class Student {
	String studentName;
	int studentID;
	Subject korea;
	Subject math;
	

	
	public Student() {
		korea = new Subject("korea", 100);
		math = new Subject("math", 90);
		
	}
	public Student(String name, int id) {
		studentName = name;
		studentID = id;
	}


}
