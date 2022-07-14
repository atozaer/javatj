package ko.co.tj;

public class WhileTest {

	public static void main(String[] args) {
		//처음값 1~10까지구할 num
		//증가값++
		//조건식 num<=10
		//합계값 sum		
		
		int num = 1;
		int sum = 0;
		
		while(num<=10) {	//true이면 반복하라 false면 탈출하라
				sum+=num;	//sum=sum+num
				num++;		//num=num+1
		}
		
		System.out.println("1부터10까지의합"+sum);
		System.out.println(num);
	}

}
