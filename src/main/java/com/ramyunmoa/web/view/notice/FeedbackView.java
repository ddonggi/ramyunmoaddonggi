package com.ramyunmoa.web.view.notice;

import com.ramyunmoa.web.entity.notice.Feedback;

public class FeedbackView extends Feedback {
	private int cmtCount;

	public FeedbackView() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackView(int id, String title, String writerId, String regdate, int hit, int cmtCount) {

		super(id, title, null, writerId, regdate, hit);
		this.cmtCount = cmtCount;
		// TODO Auto-generated constructor stub
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	@Override
	public String toString() {
		return "FeedbackView [cmtCount=" + cmtCount + "]";
	}

	

}
