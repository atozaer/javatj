package kr.co.tj;

public class Test05 {

	public static void main(String[] args) {
		int[][] numArray = {{0,1,2},{0,1,2},{0,1,2},{0,1,2}};
		//[0][0]=0 [0][1]=1 [0][2]=2
		//[1][0]=0 [1][1]=1 [1][2]=2
		//[2][0]=0 [2][1]=1 [2][2]=2
		//[3][0]=0 [3][1]=1 [3][2]=2
		for(int i = 0; i<numArray.length;i++) {
			for(int j = 0;j<numArray[i].length;j++) {
				System.out.print(numArray[i][j]);
			}
			System.out.println();
		}
		
	}

}
