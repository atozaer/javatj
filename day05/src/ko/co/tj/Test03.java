package ko.co.tj;

public class Test03 {

	public static void main(String[] args) {
		int dan=4;
//		for(int i=0;i<=9;i++) {
//			System.out.println(dan+"X"+i+"="+dan*i);
//		}
		dan = 5; int count =1;
		while(count<=9) {
			System.out.printf("%d X %d = %6d \n",dan,count,dan*count);
			count++;
		}
		
	}

}
