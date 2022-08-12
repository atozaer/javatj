package admin.view;

import java.util.List;

import controller.MainController;
import repository.AbstractRepository;
import vo.MemberVO;

public class MemberView implements AdminView {
	String listTitle, listContent, listSplit;
	
	public MemberView() {
		listTitle = "일련번호\t아이디\t이름\t연락처\t보유 적립금\t총주문수\t가입일";
		listContent = "%d\t%s\t%s\t%s\t%d\t%d\t%s";
		listSplit = "===================================================";
	}
	
	@Override
	public String menuSelector() {
		System.out.println("(l)회원 리스트, (s)회원 검색, (m)회원 정보 수정, (p)적립금 추가 지급, (그외)회원 관리 종료");
		return MainController.sc.next().toLowerCase();
	}
	
	private void printHeader() {
		System.out.println(listSplit);
		System.out.println(listTitle);
		System.out.println(listSplit);
	}
	
	private void printSplit() {
		System.out.println(listSplit);
	}
	
	public void printMemberList(List<MemberVO> memberList) {
		printHeader();
		if (memberList.size() > 0) {
			for(MemberVO member : memberList) {
				listTitle = "일련번호\t아이디\t이름\t연락처\t보유 적립금\t총 주문수\t가입일";
				System.out.println(
					String.format(listContent, 
						member.getMemberNo(),
						member.getMemberId(),
						member.getMemberName(),
						member.getTel(),
						member.getMemberPoint(),
						member.getOrderCount(),
						AbstractRepository.SDF.format(member.getRegDate())
					)
				);
			}
		}
		else {
			System.out.println("조회 된 회원이 없습니다.");
		}
		printSplit();
	}
	
	public Long searchMemberNo() {
		System.out.println("대상 회원 일련번호를 입력해 주세요");
		return MainController.sc.nextLong();
	}
	
	public MemberVO modifyMember(List<MemberVO> memberList) {
		MemberVO member = null;
		printSplit();
		System.out.println("기존 정보");
		printMemberList(memberList);
		if (memberList.size() > 0) {
			member = memberList.get(0);
			String memberName = getModifyMemberInfo("이름");
			String tel = getModifyMemberInfo("연락처");
			
			member.setMemberName((memberName.equals("exit")) ? member.getMemberName() : memberName);
			member.setTel((tel.equals("exit")) ? member.getTel() : tel);
		}
		return member;
	}
	
	public String getModifyMemberInfo(String msg) {
		System.out.println("수정 할 " + msg + "을(를) 입력 해 주세요(exit : 미수정)");
		return MainController.sc.next();
	}
	
	public void modifyResult(int result) {
		if (result > 0) {
			System.out.println("회원 정보가 정상 수정 되었습니다.");
		}
		else {
			System.out.println("회원 정보 수정 실패");
		}
	}
	
	public void notModifyTarget() {
		System.out.println("정보 수정 대상을 다시 한번 확인 해 주세요");
	}
	
	public MemberVO addMemberPoint(MemberVO member) {
		if (member != null) {
			while (true) {
				System.out.printf("%s님의 현재 적립금은 %d원 입니다.\n얼마를 증차감 하시겠습니까?\n", member.getMemberName(), member.getMemberPoint());
				int inAddPoint = MainController.sc.nextInt();
				int resultPoint = member.getMemberPoint() + inAddPoint;
				if (resultPoint < 0) {
					System.out.println("합산 적립금이 0원 이하는 될 수 없습니다.");
				}
				else {
					member.setMemberPoint(resultPoint);
					break;
				}
				
			}
		}
		else {
			notModifyTarget();
		}
		return member;
	}
}
