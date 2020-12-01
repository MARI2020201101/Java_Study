package classEx;

public class StudentEx {

	public static void main(String[] args) {
		Student mari = new Student();
		mari.studentAddress = "Japan,Tokyo";
		mari.studentID = 1;
		mari.studentName = "Mari. Y";
		
		System.out.println(mari.studentName + " is living in " + mari.studentAddress );

	}

}
