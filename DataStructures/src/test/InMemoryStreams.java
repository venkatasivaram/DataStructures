package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InMemoryStreams {
	public static void main(String[] args) throws IOException {
		String str1 = "Let us learn about In-memory Streams";
		byte[] bytes = str1.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		// initialize variable to hold the return value
		byte[] buffer = new byte[3];
		int number = 0;
		int count = 0;
		while ((number = in.read(buffer)) != -1) {
//    for(byte b: buffer) {
//     System.out.println(b);
//    }
			if (count == 2)
				in.reset();
			count++;
		}
		in.close();
	}
}
