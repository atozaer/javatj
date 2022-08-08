package repository;

import vo.MemberVO;

public class MemberRepository extends AbstractRepository<MemberVO>{

	public MemberRepository() {
		super(MemberVO.class);
	}

}
