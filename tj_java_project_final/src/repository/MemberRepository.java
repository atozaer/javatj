package repository;

import java.util.List;

import vo.MemberVO;

public class MemberRepository extends AbstractRepository<MemberVO>  {
	public MemberRepository() {
		super(MemberVO.class);
	}
	
	public String searchMemberId(String memberName, String tel) {
		List<MemberVO> memberList = null;
		String returnId = null;
		memberList = selectByQuery(String.format("Select member_id from member where member_name = '%s' and tel = '%s'", memberName, tel));
		if (memberList.size() > 0) {
			returnId = memberList.get(0).getMemberId();
		}
		return returnId;
	}
	
	public MemberVO searchMemberPwd(String memberId, String tel) {
		List<MemberVO> memberList = null;
		MemberVO member = null;
		int memberNo = 0;
		memberList = selectByQuery(String.format("Select member_no from member where member_id = '%s' and tel = '%s'", memberId, tel));
		if (memberList.size() > 0) { 
			member = memberList.get(0);
		}
		return member;
	}
	
	public int selectByMemberId(String memberId) {
		List<MemberVO> memberList = null;
		int result = 0; 
		
		memberList = selectByQuery(String.format("Select member_id from member where member_id = '%s'", memberId));
		result = memberList.size();
		
		return result;
	}
	
	public MemberVO loginMember(String loginId, String loginPwd) {
		List<MemberVO> memberList = null;
		memberList = selectByQuery(String.format("Select member_no, member_name from member where member_id = '%s' and password = '%s'", loginId, loginPwd));
		
		return (memberList.size() == 0) ? null : memberList.get(0);
	}
	
	public int deleteMember(Long memberNo, String deletePwd) {
		return deleteByQuery(String.format("delete from member where member_no = %d and password = '%s'", memberNo, deletePwd));
	}
	
	public int selectModifyMember(Long memberNo, String selectPwd) {
		List<MemberVO> memberList = null;
		memberList = selectByQuery(String.format("select member_no from member where member_no = %d and password = '%s'", memberNo, selectPwd)); 
		return memberList.size();
	}
}
