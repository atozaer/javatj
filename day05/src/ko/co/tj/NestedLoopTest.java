package ko.co.tj;

public class NestedLoopTest {

	public static void main(String[] args) {
		int dan =2;
		int count = 1;
		
		aaa: for(dan=2;dan<=9;dan++) {
			
				for(count=1;count<=9;count++) {
					
					if(dan==5) break aaa;
					System.out.print(dan+"X"+count+"="+dan*count+" ");
				}
				System.out.println();
		}
		
	}

}
