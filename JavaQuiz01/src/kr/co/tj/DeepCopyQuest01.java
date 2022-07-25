// ——————————————— 배열 깊은 복사 문제
// main 메소드가 포함되어 있는 DeepCopyQuest01 클래스를 생성.(* 원하는 클래스명이 있으면 별도 생성후 사용)
// 크기가 10인 문자열을 담을 수 있는 배열을 하나 만들어서
// 책이름 5개를 배열에 넣으시고
// "어린왕자", "칼의노래", "연금술사", "2021 트랜드 코리아","인연"
// 크기가 10인 bookCopy 배열을 만들고
// bookCopy의 index 5~9에 books에 있는 내용을 복사해 넣으시오
// books 0~4까지를 출력하시오
// bookCopy의 5~9까지를 출력하시오
// 결과
/*
books[0] : 어린왕자 
books[1] : 칼의노래 
books[2] : 연금술사 
books[3] : 2021 트랜드 코리아 
books[4] : 인연 
-------------------------
booksCopy[5] : 어린왕자
booksCopy[6] : 칼의노래
booksCopy[7] : 연금술사
booksCopy[8] : 2021 트랜드 코리아
booksCopy[9] : 인연
*/

package kr.co.tj;

import java.util.Arrays;

public class DeepCopyQuest01 {

	public static void main(String[] args) {
		String[] arr = new String[10];
		arr[0] = "어린왕자";
		arr[1] = "칼의노래";
		arr[2] = "연금술사";
		arr[3] = "2021 트랜드 코리아";
		arr[4] = "인연";
		
		String[] arr2 = new String[10];
		System.arraycopy(arr, 0, arr2, 0, arr.length);		
		
		System.out.println(arr2[0]);

	}

}
