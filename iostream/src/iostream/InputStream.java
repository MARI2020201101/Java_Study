package iostream;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args)  {
		FileInputStream ir = null;
		try {
			ir = new FileInputStream("C:\\Users\\dbrtm\\eclipse-workspace\\iostream\\Today.txt");
			while(true) {
			int i = ir.read();
			System.out.println(i);
			
			if(i == -1) break;			}
			
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			System.out.println("Finish");
		}
		

	}

}
