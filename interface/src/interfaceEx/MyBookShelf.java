package interfaceEx;

import java.util.ArrayList;

public class MyBookShelf {

	public static void main(String[] args) {
		Shelf mybookShelf = new Shelf();
		mybookShelf.enQueue("Little Princess1");
		mybookShelf.enQueue("Little Princess2");
		mybookShelf.enQueue("Little Princess3");
		
		 ArrayList<String> books = mybookShelf.getShelf();
		 System.out.println(books);
		 
		 mybookShelf.deQueue(1);
		 ArrayList<String> books2 = mybookShelf.getShelf();
		 System.out.println(books2);

	}

}
