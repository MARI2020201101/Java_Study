package collections;

import java.util.HashMap;
import java.util.Iterator;

public class Hashmap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(101, "str1");
		hashmap.put(102, "str2");
		hashmap.put(103, "str3");
		hashmap.put(104, "str4");
		
		System.out.println(hashmap);
		hashmap.remove(104);
		System.out.println(hashmap);
		
		
		System.out.println(hashmap.get(101));
		System.out.println("-----------------");
		
		Iterator ir = hashmap.keySet().iterator();
		while(ir.hasNext()) {
			String s =hashmap.get(ir.next());
			System.out.println(s);
		}
		
		
		

	}

}
