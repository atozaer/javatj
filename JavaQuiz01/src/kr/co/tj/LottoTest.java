// ——————————————— 배열 문제
// 새로운 패키지를 만들고
// main 메소드가 포함된 LottoTest 클래스를 생성한다.
// 무한 반복을 하며 로또 예상 번호를 계산 여부를 묻는다.
// 로또 번호를 계산 받는걸 선택 하면 6번의 루프를 돌려
// Math.random() 함수를 이용해서 1~45까지의 랜덤 값을 정수형 배열에 대입 받아 출력해 준다.
// 주의! 기본적으로 배열 사용시 중복 제거는 안됩니다. 중복이 제거 될 수 있도록 처리해보는것도 센스입니다.
// 로또 번호를 계산 받으시겠습니까?(y/n)
// y
// [32, 35, 19, 5, 40, 9, 15]
// 로또 번호를 계산 받으시겠습니까?(y/n)
// n
// 프로그램 종료

package kr.co.tj;

import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String protocol, protocol1;
		int[] lotto = new int[6];

		System.out.println("로또 번호를 계산 받으시겠습니까?(y/n)");
		protocol1 = scan.next();
		protocol = protocol1.toUpperCase();
		if(protocol.equals("Y")) {
			for (int i = 0; i < 6; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;

				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			System.out.print("[ ");
			for (int i = 0; i<lotto.length; i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println("]");
		}else {
			System.out.println("프로그램 종료");
		}
		
	}

}
