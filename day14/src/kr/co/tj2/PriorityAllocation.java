package kr.co.tj2;

public class PriorityAllocation implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("우선순위가 높은 고객우선으로 대기열에서 가져옵니다.");
	}

	@Override
	public void senCallToAgent() {
		System.out.println("다음 순서의 상담원에게 배분합니다.");
	}

}
