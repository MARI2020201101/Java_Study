package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		Stream<String> streamList = list.stream();
		streamList.forEach(s->System.out.println(s));
	}

}
