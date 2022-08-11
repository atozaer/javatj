package repository;

import java.util.List;

import vo.MemberVO;

public class MemberRepository extends AbstractRepository<MemberVO> {
	public MemberRepository() {
		super(MemberVO.class);
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
		memberList = selectByQuery(
				String.format("Select member_no, member_name from member where member_id = '%s' and password = '%s'",
						loginId, loginPwd));

		return (memberList.size() == 0) ? null : memberList.get(0);
	}

	public int deleteMember(Long memberNo, String deletePwd) {
		return deleteByQuery(
				String.format("delete from member where member_no = %d and password = '%s'", memberNo, deletePwd));
	}

	public MemberVO selectModifyMember(Long memberNo, String selectPwd) {
		List<MemberVO> memberList = null;
		MemberVO member = null;
		
		memberList = selectByQuery(String
				.format("select * from member where member_no = %d and password = '%s'", memberNo, selectPwd));
		
		if (memberList.size() > 0) {
			member = memberList.get(0);
		}
		return member;
	}

	

	public List<MemberVO> selectMemberNameTel(String memberName, String tel) {
		List<MemberVO> memberList = null;
		memberList = selectByQuery(
				String.format("Select member_id,member_name,tel from member where member_name = '%s' and tel = '%s'",
						memberName, tel));

		return memberList;
	}

	public List<MemberVO> selectMemberIdTel(String memberId, String tel) {
		List<MemberVO> memberList = null;
		memberList = selectByQuery(String.format(
				"Select member_id,password,member_name,tel from member where member_id = '%s' and tel = '%s'", memberId,
				tel));

		return memberList;
	}
	
	public List<MemberVO> selectMemberByIdNo(int memberNo) {
		List<MemberVO> memberList = null;
		memberList = selectByQuery(
				String.format("Select member_no,member_id,member_name,tel,reg_date from member where member_no = '%d'",
						memberNo));
		System.out.println("Select member_no,member_id,member_name,tel,reg_date from member where member_no = '%d'");
		
		return memberList;
	}

}
