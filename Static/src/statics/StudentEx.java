package statics;

public class StudentEx {

	public static void main(String[] args) {
		Student mari = new Student();
		mari.studentName = "mari";
		
		System.out.println(mari.studentName + Student.serialID);
		
		Student nina = new Student();
		nina.studentName = "nina";
		
		System.out.println(nina.studentName + Student.serialID);

	}

}
