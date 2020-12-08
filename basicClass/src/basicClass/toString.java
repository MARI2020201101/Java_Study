package basicClass;

class Book { 
	String bookName;
	String author;
	
	@Override
	public String toString() {
		
		return bookName + " , " + author;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Book) {
			Book book = (Book)obj;
			
			if(book.bookName == bookName) {
				return true;
			}
		}return false;
	}
		
		
	
}

public class toString {
	
	

	

	public static void main(String[] args) {
		Book book = new Book();
		book.bookName = "Little Princess";
		book.author = "mari";
		
		System.out.println(book);
		

	}

}
