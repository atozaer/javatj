package ko.co.tj;

public class Test1 {

	public static void main(String[] args) {
		float silsu1 = 2.0f;
		float silsu2 = 1.1f;
		float result = silsu1 - silsu2;
		
		System.out.println("계산한 결과="+result);

		double silsu3 = 2.0;
		double silsu4 = 1.1;
		double result1 = silsu3 - silsu4;
		System.out.println("계산한 결과="+result1);
		
		double result2 = ((int)silsu3*10 - (int)silsu4*5);
		System.out.println(result2);
		// 컴퓨터는 소수점이하의 숫자를 계산 할 때는 근사치를 찾는다
		// 정수형으로 형변환해서 계산해야 정확한 값이 나온다
		
		
	}

}
