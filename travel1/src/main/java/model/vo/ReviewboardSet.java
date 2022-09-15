package model.vo;

import java.util.ArrayList;

public class ReviewboardSet {
	private ReviewboardVO ReviewboardVO;
	private ArrayList<CommentsVO> comments = new ArrayList<CommentsVO>();
	public ReviewboardVO getReviewboardVO() {
		return ReviewboardVO;
	}
	public void setReviewboardVO(ReviewboardVO reviewboardVO) {
		ReviewboardVO = reviewboardVO;
	}
	public ArrayList<CommentsVO> getComments() {
		return comments;
	}
	public void setComments(ArrayList<CommentsVO> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "ReviewboardSet [ReviewboardVO=" + ReviewboardVO + ", comments=" + comments + "]";
	}
	
}
