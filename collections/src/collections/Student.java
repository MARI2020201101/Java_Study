package collections;

public class Student {
	
	int studentNumber;
	String studentName;
	
	Student(int studentNumber, String studentName){
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		
		
		
	}

	@Override
	public String toString() {
		return studentNumber +" with " + studentName;
	
	}

	@Override
	public int hashCode() {
		return studentNumber;
	}

	@Override
	public boolean equals(Object obj) {
		Student stu = (Student)obj;
		if (this.studentNumber == stu.studentNumber) 
			return true;
		else return false;
	}

}
