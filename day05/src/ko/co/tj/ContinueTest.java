package ko.co.tj;

public class ContinueTest {

	public static void main(String[] args) {
		int sum = 0;
		int num;
		
		for(num=1;num<=100;num++) {
			
			if((num%3)!=0)continue;
			sum+=num;
		}
		System.out.println(num);
		System.out.println(sum);
	}

}
