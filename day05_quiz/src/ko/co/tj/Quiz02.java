package ko.co.tj;

public class Quiz02 {

	public static void main(String[] args) {
//		int num = 1;
//		int sum = 0;
//
//		while(num<=10) {
//			sum+=num;
//			num++;
//			
//		}
//		System.out.println("1부터10까지의합="+sum);
//		System.out.println("while문이끝난후의num값="+num);
		int sum = 0;
		int count = 0;
		for(int i = 0;i<=10;i++) {
			sum+=i;
			count++;
			System.out.println("for문의 변화 num값="+i);
		}
		System.out.println("1부터10까지의합="+sum);
		System.out.println(count);
		
	}

}
