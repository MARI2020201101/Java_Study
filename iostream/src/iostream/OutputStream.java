package iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {

	public static void main(String[] args) {
		try { 
			FileOutputStream os = new FileOutputStream("C:\\Users\\dbrtm\\eclipse-workspace\\iostream\\Today2.txt");
			String str = "æ»≥Á«œººø‰";
			byte[] b = str.getBytes();
			os.write(b);
			
			
		}catch(IOException e){
			System.out.println(e);
			
		}

	}

}
