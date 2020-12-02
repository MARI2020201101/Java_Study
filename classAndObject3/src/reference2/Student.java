package reference2;


public class Student {
	String studentName;
	int studentID;
	Subject korea;
	Subject math;

	public void setkorea() {
		korea.setSubjectName("korea");
		korea.setSubjectScore(100);
	}
	public void setmath() {
		math.setSubjectName("math");
		math.setSubjectScore(90);
	}


}