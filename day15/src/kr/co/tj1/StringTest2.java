package kr.co.tj1;

public class StringTest2 {

	public static void main(String[] args) {
		String java = new String("자바");
		String android = new String("안드로이드");
		System.out.println(System.identityHashCode(java));
		
		java = java.concat(android);
		
		System.out.println(java);
		System.out.println(System.identityHashCode(java));
		System.out.println(System.identityHashCode(android));
	}

}
