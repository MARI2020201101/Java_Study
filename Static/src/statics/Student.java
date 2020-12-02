package statics;

public class Student {
	int studentID;
	String studentName;
	
	
	static int serialID = 100;
	
	public Student() {
		serialID++;
		studentID = serialID;
	}

}
