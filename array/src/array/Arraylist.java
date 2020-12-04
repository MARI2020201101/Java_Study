package array;
import java.util.ArrayList;

public class Arraylist {
	
	public static void main(String[] args) {
		
		ArrayList<String> book = new ArrayList<String>();
		book.add("papipupepo");
		book.add("abc");
	
		for(String list : book) {
		System.out.println(list);
		}
		
	}
}
