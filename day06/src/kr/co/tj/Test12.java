package kr.co.tj;

public class Test12 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int total = 0;
		int num = 0;

		for (int i = 0; i < arr.length; i++) {
			num++;
			arr[i] = num;
		}
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println(total);
	}

}
