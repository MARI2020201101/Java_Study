package collections;

import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();
		Student stu1 = new Student(101, "mari");
		Student stu2 = new Student(102, "momo");
		Student stu3 = new Student(103, "nina");
		Student stu4 = new Student(104, "yumi");
		Student stu5 = new Student(104, "yuna");
		
		hashset.add(stu1);
		hashset.add(stu2);
		hashset.add(stu3);
		hashset.add(stu4);
		hashset.add(stu5);
		
		System.out.println(hashset);
		
		hashset.remove(stu4);
		System.out.println(hashset);
		
		
		

	}

}
