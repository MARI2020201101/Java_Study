package basicClass;

public class Equals {

	public static void main(String[] args) {
		String str = new String("str");
		String str2 = new String("str");
		if(str==str2) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
		
		if(str.equals(str2)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}

		System.out.println("-----------------");
		Book mybook = new Book();
		mybook.bookName = "Little Princess";
		Book mybook2 = new Book();
		mybook2.bookName = "Little Princess";
		
		if(mybook.bookName==mybook2.bookName) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
		if(mybook.bookName.equals(mybook2.bookName)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
		
		System.out.println("-----------------");
		if(mybook==mybook2) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
		if(mybook.equals(mybook2)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
	}

}
