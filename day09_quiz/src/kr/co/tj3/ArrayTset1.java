package kr.co.tj3;

public class ArrayTset1 {

	public static void main(String[] args) {
		//int[][] arr = {{1,2,3},{4,5,6,7}};
		int[][] arr = new int[2][0];
		arr[0] = new int[3];
		arr[1] = new int[4];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		arr[1][3] = 7;
		int i,j;
		for(i=0; i<arr.length;i++) {
			for(j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(",\t"+arr[i].length);
			System.out.println();
		}
		
	}

}
