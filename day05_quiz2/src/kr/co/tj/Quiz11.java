package kr.co.tj;

public class Quiz11 {

	public static void main(String[] args) {
		int i =0;
		int j =0;
		
		for(i=0;i<3;i++) {
			for(j=0;j<i+1;j++) {
				System.out.print("*");	
				}
			System.out.println();
			}
		for(i=3;i>=1;i--) {
			for(j=1;j<=1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


