package kr.co.tj;

public class Test01 {

	public static void main(String[] args) {
		int a = 10;	//a 정수형
		//int[] arr;	//int[]은 정수형을가르키는 배열타입
		//arr = new int[3];	//배열타입의 기본값은 null이 들어감 
							//int배열 타입의기본값은 0
		
		int[] arr = new int[3];
		System.out.printf("배열의길이는 %d\n", arr.length);
		arr[0]=1;
		arr[1]='A';
		//arr[2]=1.5;
		System.out.printf("arr의 첫번째 공간 : %d\n",arr[0]);
		System.out.printf("arr의 두번째 공간 : %d\n",arr[1]);
		System.out.printf("arr의 세번째 공간 : %d\n",arr[2]);
		
		
		
	}

}
