package model.vo;

import java.util.ArrayList;

public class AskboardSet {
	private AskboardVO AskboardVO;
	private ArrayList<AskcommentVO> askcomment = new ArrayList<AskcommentVO>();
	public AskboardVO getAskboardVO() {
		return AskboardVO;
	}
	public void setAskboardVO(AskboardVO askboardVO) {
		AskboardVO = askboardVO;
	}
	public ArrayList<AskcommentVO> getAskcomment() {
		return askcomment;
	}
	public void setComments(ArrayList<AskcommentVO> askcomment) {
		this.askcomment = askcomment;
	}
}
