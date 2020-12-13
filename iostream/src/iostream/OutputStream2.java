package iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream2 {

	public static void main(String[] args) {
		byte[] bs = new byte[26];
		byte alphabet = 65;
		for(int i = 0; i <bs.length ; i++) {
			bs[i] = alphabet++;
		}
		try(FileOutputStream fos = new FileOutputStream("Today3.txt")) {
			
			fos.write(bs);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
