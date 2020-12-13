package iostream;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream2 {

	public static void main(String[] args) {
		int i = 0;
		try(FileInputStream fis = new FileInputStream("Today.txt")){
			while((i = fis.read()) != -1 ) {
			
			System.out.print((char)i);
			}
			
		}catch(IOException e){
			System.out.println(e.toString());
			
			
		}System.out.println("finish");

	}

}
