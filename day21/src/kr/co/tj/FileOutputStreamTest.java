package kr.co.tj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fo = null;
		String msg = "FileOutputStreamTest hello!! 한글";

		byte[] byteArray = msg.getBytes();
		try {
			fo = new FileOutputStream("./src/tj.txt", true);
			fo.write(byteArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
