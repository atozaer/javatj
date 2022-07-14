package kr.co.tj;

public class CharArrayTest {

	public static void main(String[] args) {
		char[] alpah = new char[26];
		char ch = 'A';
		
		for(int i=0;i<alpah.length;i++) {
			alpah[i] = ch++;
			System.out.print(alpah[i]);
		}
		System.out.println();
		for(char alpha : alpah) {
			System.out.println(alpha+","+(int)alpha);
		}
//		for(int i=0; i<alpah.length; i++) {
//			System.out.println(alpah[i]+","+(int)alpah[i]);
//		}
	}

}
