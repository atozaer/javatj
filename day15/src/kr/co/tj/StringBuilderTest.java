package kr.co.tj;

public class StringBuilderTest {

	public static void main(String[] args) {
		String java = new String("자바");
		String android = new String("안드로이드");
		
		StringBuilder buffer = new StringBuilder(java);
		System.out.println(System.identityHashCode(buffer));
		buffer.append("안드로이드");
		System.out.println(System.identityHashCode(buffer));
		
		java = buffer.toString();
		System.out.println(java);
		System.out.println(android);
	}

}
