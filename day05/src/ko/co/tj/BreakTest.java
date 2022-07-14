package ko.co.tj;

public class BreakTest {

	public static void main(String[] args) {
		int sum = 0;
		int num;
		
		for(num=1;num<=100;num++) {
			sum+=num;
			if(num>=100)break;
			
		}
		System.out.println(num);
		System.out.println(sum);
	}

}
