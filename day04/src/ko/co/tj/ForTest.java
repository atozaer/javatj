package ko.co.tj;

public class ForTest {

	public static void main(String[] args) {
		int count = 1;
		int sum = 0;
		int i=0;
		
		for (int i1 = 0; ; i1++) {
			sum += i1;
			
			if(sum>200) break;
		}
		System.out.println(i);
		System.out.println("for문 결과 : " + sum);

		int num = 1;
		int total = 0;

		while (num <= 10) {
			total += num;
			num++;
		}
		System.out.println("while문 결과 : " + total);
	}

}
