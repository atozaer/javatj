package kr.co.tj;

import java.util.HashSet;
import java.util.Scanner;

class Lotto {
	HashSet lottoNumber = new HashSet();
	Scanner scan = new Scanner(System.in);

	public void lottoMain() {
		while (true) {
			System.out.println("로또 번호를 받으시겠습니까? (Y/N)");
			if (scan.next().toUpperCase().equals("Y")) {
				lottoRun();
				lottoShow();
				System.out.println("Y");
			} else {
				System.out.println("로또 번호를 받지않습니다.");
				break;
			}
		}

	}

	public void lottoRun() {
		for (int i = 0; i < 6; i++) {
			lottoNumber.add((int)Math.random());
		}
	}

	public void lottoShow() {

	}
}

public class LottoTest {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.lottoMain();
	}

}
