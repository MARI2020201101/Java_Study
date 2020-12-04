package array;
import java.util.ArrayList;


public class Student {
	int studentID;
	String studentName;
	ArrayList<Subject> subjectList;
	
	public Student(int studentID , String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		
	}
	public void addSubject(int subjectScore, String subjectName) {
		Subject subject = new Subject();
		subject.setSubjectScore(subjectScore);
		subject.setSubjectName(subjectName);
		
		subjectList.add(subject);
	}
	

	public void studentInfo() {
		for(Subject subject : subjectList) {
		System.out.println(studentName + subject.getSubjectName());
		}
		}
	
}
