package repository;

import vo.BoardVO;

public class BoardRepository extends AbstractRepository<BoardVO>  {
	public BoardRepository() {
		super(BoardVO.class);	
	}
}
