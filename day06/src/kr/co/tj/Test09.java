package kr.co.tj;

public class Test09 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		for(int i =0; i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		int[] arr1 = new int[] {1,2,3,4,5};
		for(int i = 0; i<arr1.length;i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		
		String[] fruit = {"사과", "포도", "참외"};
		for(String str:fruit) {
			System.out.print(str);
		}
		System.out.println();
		
		String[] fruit1 = new String[] {"사과", "포도", "참외"};
		for(String str:fruit1) {
			System.out.print(str);
		}
		System.out.println();
		
	}

}
