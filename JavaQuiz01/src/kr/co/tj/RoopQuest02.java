// ——————————————— 반복문, 조건문 문제
// main 메소드가 포함되어 있는 RoopQuest02 클래스를 생성.(* 원하는 클래스명이 있으면 별도 생성후 사용)
// 1~100까지의 수 중 소수
//1) 소수를 찾기 : 1, 자기자신만 약수로 갖는 수
//소수 : 2,3,5,7,11 ...
//7 소수인가?
//1~7까지 수로 7을 나눠서 나눠지는(나머지가 0이되는) 수가 2개면 소수.
// 출력 예)
// 2은(는) 소수다.
// 4은(는) 소수가 아니다.
package kr.co.tj;

public class RoopQuest02 {

	public static void main(String[] args) {
		int count;

		for (int i = 2; i <= 200; i++) {
			count = 0;
			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println(i + "은(는) 소수입니다.");
			}else if (count != 1) {
				System.out.println(i+"은(는) 소수가 아닙니다.");
			}
		}
	}

}
