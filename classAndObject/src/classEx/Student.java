package classEx;

public class Student {
	int studentID;
	String studentName;
	String studentAddress;
	
	public void setName(String name) {
		this.studentName = name;
		
	}
	
	public static void main(String[] args){
		Student mari = new Student();
		mari.setName("mari.y");
		System.out.println(mari.studentName );
		
	}

}
