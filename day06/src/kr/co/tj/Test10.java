package kr.co.tj;

public class Test10 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4};
		int[] arr2 = arr1;
		for(int x:arr1) {
			System.out.println(x);
		}
		for(int x:arr2) {
			System.out.println(x);
		}
	}

}
