package array;

public class Book {
	String bookname;
	String author;
	
	public Book(String bookname, String author) {
		this.bookname = bookname;
		this.author = author;
	}

	public void bookInfo() {
		System.out.println(this.bookname +this.author);
	}
	
	

}
