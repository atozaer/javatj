package kr.co.tj;

public class Test03 {

	public static void main(String[] args) {
		String[] str1 = new String[3];
		str1[0] = "Hello";
		str1[1] = "Java";
		str1[2] = "World";
		String[] str2= {"Hello", "Java", "World"};
		if(args.length==0) {
			args = new String[] {"Hello", "Java", "World"};
		}
		for(int i = 0; i<str2.length;i++) {
			System.out.printf("str1:%s, str2:%s, args:%s\n", str1[i],str2[i],args[i]);			
		}
	}

}
