package ko.co.tj;

public class Quiz6 {

	public static void main(String[] args) {
		boolean a = false, b = true, c=true;
		boolean result1=false,result2=false,result3=false,result4=false;
		
		result1 = a&&b;
		result2 = a||b;
		result3 = b&&c;
		result4 = !a;
		System.out.println(result1+":"+result2+":"+result3+":"+result4);
		
	}

}
