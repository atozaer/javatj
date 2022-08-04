package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import repository.BoardRepository;
import repository.MemberRepository;
import view.MemberView;
import vo.MemberVO;

public class MemberController extends Controller {
	MemberRepository memberRepository;
	List<MemberVO> memberList;
	MemberView memberView;
	
	public MemberController() {
		super("회원번호\t아이디\t이름\t연락처\t가입일", "%d\t%s\t%s\t%s\t%s");
		memberRepository = new MemberRepository();
		memberView = new MemberView();
	}
	
	@Override
	void selectMenu() {
		controllerResult = true;
		memberList = null;
		
		memberView.menuSelector();
		switch (memberView.menuCode) {
			case "s":
				int searchNo = memberView.search();
				
				memberList = memberRepository.selectFindById(searchNo); // 회원 일련번호 조회
				
				memberView.searchResult(memberList);
				break;
			case "l":				
				memberView.list(memberRepository.selectAll());
				break;
			case "c":
				if (!loginCheck(false)) break; 
				
				while (true) {
					String inputId = memberView.joinIdInput();
					int memberResult = memberRepository.selectByMemberId(inputId);
					
					int result = memberRepository.save(memberView.join(memberResult, inputId));
					
					if (result > 0) {
						memberView.joinResult("가입 완료");
					}
					else {
						memberView.joinResult("가입 실패");
						continue;
					}
					break;
				}
				break;
			case "u":
				if (!loginCheck(false)) break;
				
				while (true) {
					List<String> loginInfo = memberView.login();
					MemberVO loginMember = memberRepository.loginMember(loginInfo.get(0), loginInfo.get(1));
					
					if (loginMember == null) {
						memberView.loginFail();
						continue;
					}
					else {
						sessionNo = loginMember.getMemberNo();
						sessionName = loginMember.getMemberName();
						break;
					}
				}
				break;
			case "d":
				if (!loginCheck(true)) break;

				if (memberView.hackCheck().equals("y")) {
					while (true) {					
						String deletePass = memberView.passwordCheck();
						
						int deleteResult = memberRepository.deleteMember(sessionNo, deletePass);
						
						if (deleteResult > 0) {
							memberView.hackResult("정상적으로 탈퇴 되었습니다.");
							sessionNo = null;
							sessionName = null;
							break;
						}
						else {
							memberView.hackResult("입력 된 비밀번호가 일치 하지 않습니다.");
						}
					}
				}
				break;
			case "m":
				if (!loginCheck(true)) break;
				while (true) {
					
					String modifyPass = memberView.passwordCheck();
					int count = memberRepository.selectModifyMember(sessionNo, modifyPass);
					if (count == 0) {
						continue;
					}
					else {
						
						int resultNo = 
								memberRepository.update(
										memberView.modify()
								);
						if (resultNo > 0) {
							memberView.modifyResult("정상적으로 정보가 수정 되었습니다.");
						}
						else {
							memberView.modifyResult("정보 수정에 실패했습니다.");
							continue;
						}
						break;
					}
				}
				break;
			case "o":
				if (!loginCheck(true)) break;
				sessionNo = null;
				sessionName = null;
				break;
			case "e":
				controllerResult = false;
				break;
			default:
				memberView.menuReSelector();
				break;
		}
	}

}
