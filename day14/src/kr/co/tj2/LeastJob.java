package kr.co.tj2;

public class LeastJob implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("대기가 적은 상담원 순서대로 대기열에서 가져옵니다.");
	}

	@Override
	public void senCallToAgent() {
		System.out.println("다음 순서의 상담원에게 배분합니다.");
	}

}
