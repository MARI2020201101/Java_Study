package interfaceEx;

import java.util.ArrayList;

public class Shelf implements Queue{
	
	ArrayList<String> book;
	
	public Shelf() {
		book = new ArrayList<String>();
	}
	public ArrayList<String> getShelf(){
		return book;
	}
	
	@Override
	public void enQueue(String title) {
		book.add(title);
	}

	@Override
	public void deQueue(int num) {
		book.remove(num);
		
	}

}
