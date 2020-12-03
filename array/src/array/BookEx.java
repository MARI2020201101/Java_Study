package array;

public class BookEx {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		library[0] = new Book("little princess","mari");
		library[1] = new Book("lovely princess","mari");
		library[2] = new Book("cool princess","mari");
		library[3] = new Book("smart princess","mari");
		library[4] = new Book("beauty princess","mari");
		
		for(int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
		}
		
		for(int i = 0; i < library.length; i++) {
		library[i].bookInfo();
		}
		
		

	}

}
