package kr.co.tj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Lotto {
	HashSet<Integer> lottoNumber = null;
	Scanner scan = new Scanner(System.in);

	public void lottoMain() {
		while (true) {
			System.out.println("로또 번호를 받으시겠습니까? (Y/N)");
			if (scan.next().toUpperCase().equals("Y")) {
				lottoNumber = new HashSet<Integer>();
				lottoRun();
				lottoShow();
			} else {
				System.out.println("로또 번호를 받지않습니다.");
				break;
			}
		}
	}

	public void lottoRun() {
		while (lottoNumber.size() < 6) {
			lottoNumber.add((int) (Math.random() * 45) + 1);
		}
	}

	public void lottoShow() {
		System.out.println(lottoNumber);
	}
}

public class LottoTest {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.lottoMain();
	}
}
