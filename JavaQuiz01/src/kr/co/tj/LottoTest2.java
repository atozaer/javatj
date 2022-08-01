// ——————————————— 클래스 문제(리펙토링 - 단일책임의 원칙)
// Refactoring 기법 공부 : https://dev-truly.tistory.com/entry/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-%EB%A6%AC%ED%8E%99%ED%86%A0%EB%A7%81Refectoring-5%EB%8C%80-%EC%9B%90%EC%B9%99SOLID
// 단일 책임의 원칙 : 작성 된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임을 수행하는데 집중 되어 있어야 한다.
// 상단에 생성된 LottoTest 클래스는 단일 원칙 기법에 위배 됨으로 분할 작업이 필요 할거 같다.
// 로또 번호만을 관장하는 Lotto 클래스와 기본 흐름을 관장하는 LottoMain 클래스를 분할 해서 코딩해 보자
// Lotto 인스턴스 변수 : 로또번호 6자리를 등록하는 배열 변수 lottoNumbers
// Lotto 클래스 역할 1. 로또 번호를 계산 하겠냐를 묻고 답변값을 입력 받아 LottoMain으로 반환 메소드
// Lotto 클래스 역할 2. 로또 번호 계산 해서 배열 변수 삽입 메소드
// Lotto 클래스 역할 3. 로또 번호가 계산 등록된 배열변수를 출력하는 메소드 출력
// LottoMain에서는 전달 받은 답변값을 활용하여 로또 계산 프로세스 또는 종료 프로세스 분기
// 로또 계산 프로세스를 진행 하는 경우 로또 번호를 계산하여 출력
// 종료 실행시 “프로그램 종료”

package kr.co.tj;

import java.util.Scanner;

import javax.lang.model.util.SimpleAnnotationValueVisitor14;

class Lotto {
	int[] lottoNumbers = new int[6];

	public void LottoMain() {
		Scanner scan = new Scanner(System.in);
		System.out.println("로또번호를 받으시겠습니까??? y/n");
		String yorn = scan.next();
		int count = 0;
		while (count == 0) {
			if (yorn.equals("y") || yorn.equals("Y")) {
				lottoRun();
				lottoShow();
				count++;
			} else {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	public void lottoRun() {
		for (int i = 0; i < 6; i++) {
			lottoNumbers[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (lottoNumbers[i] == lottoNumbers[j]) {
					i--;
					break;
				}
			}
		}

	}
	
	public void lottoShow() {
		System.out.print("[ ");
		for (int i = 0; i < lottoNumbers.length; i++) {
			System.out.print(lottoNumbers[i] + " ");
		}
		System.out.println("]");
	}

}

public class LottoTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Lotto lotto = new Lotto();
		lotto.LottoMain();

	}

}
