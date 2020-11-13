package com.uver.vo;

import com.uver.cmn.DTO;

public class LikeVO extends DTO {

	/** pk 좋아요 순번 */
	private int likeNo;
	/** fk 댓글 순번 */
	private int commentSeq;
	/** fk 멤버 순번 */
	private int memberSeq;
	/** 좋아요 체크 */
	private int likeCheck;

	public LikeVO() {
	}

	public LikeVO(int likeNo, int commentSeq, int memberSeq, int likeCheck) {
		super();
		this.likeNo = likeNo;
		this.commentSeq = commentSeq;
		this.memberSeq = memberSeq;
		this.likeCheck = likeCheck;
	}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}

	@Override
	public String toString() {
		return "LikeVO [likeNo=" + likeNo + ", commentSeq=" + commentSeq + ", memberSeq=" + memberSeq + ", likeCheck="
				+ likeCheck + ", toString()=" + super.toString() + "]";
	}


}
