package kr.co.tj1;

public class AdvancedLevel extends PlayerLevel {

	@Override
	void run() {
		System.out.println("빨리달립니다.");
	}

	@Override
	void jump() {
		System.out.println("높이 Jump합니다.");
	}

	@Override
	void turn() {
		System.out.println("Turn 못하지롱");
	}

	@Override
	void showLevelMessage() {
		System.out.println("******** 중급자 레벨입니다. ********");
	}

}
