package kr.co.tj;

public class Test06 {

	public static void main(String[] args) {
		int a =10;
		int[] arr1 = new int[4];
		int[][] arr2 = new int[2][];
		arr2[0]=new int[4];
		arr2[1]=new int[2];
		//arr2[1][1]=100;
		
		for(int i = 0; i<arr2.length;i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
		
	}

}
