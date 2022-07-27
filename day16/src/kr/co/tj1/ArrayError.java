package kr.co.tj1;

public class ArrayError {

	public static void main(String[] args) {
		try {
			int[] array = {1,2,3,4,5};
			int i = 0;
			
			for(i = 0; i<array.length; i++) {
				System.out.print(array[i]+" ");
			}
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("인덱스 5는 사용할 수 없네요!");
			//e1.printStackTrace();
		}
	}

}
