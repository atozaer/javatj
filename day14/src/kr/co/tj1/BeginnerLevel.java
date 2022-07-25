package kr.co.tj1;

public class BeginnerLevel extends PlayerLevel {

	@Override
	void run() {
		System.out.println("천천히달립니다.");
	}

	@Override
	void jump() {
		System.out.println("Jump 못하지롱");
	}

	@Override
	void turn() {
		System.out.println("Turn 못하지롱");
	}

	@Override
	void showLevelMessage() {
		System.out.println("******** 초급자 레벨입니다. ********");
	}

}
