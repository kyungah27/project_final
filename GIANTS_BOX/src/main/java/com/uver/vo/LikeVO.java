package com.uver.vo;

import com.uver.cmn.DTO;

public class LikeVO extends DTO {

	/** fk 댓글 순번 */
	private int commentSeq;
	/** fk 멤버 순번 */
	private int userSeq;

	public LikeVO() {
	}

	public LikeVO(int commentSeq, int userSeq) {
		super();
		this.commentSeq = commentSeq;
		this.userSeq = userSeq;
	}

	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Override
	public String toString() {
		return "LikeVO [commentSeq=" + commentSeq + ", userSeq=" + userSeq + ", toString()=" + super.toString() + "]";
	}

}
