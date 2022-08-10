package kr.co.tj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderTest {
	
	public static void main(String[] args) throws IOException {
//		Reader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String txt = br.readLine();
		
		System.out.println(txt);
	}
}
