package kr.co.tj;

public class Test11 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4};
		int[] arr2 = new int[4];
		//System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		arr2=arr1.clone();
		
		for(int i = 0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
			System.out.print(arr1[i]);
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]);
		}
	}

}
