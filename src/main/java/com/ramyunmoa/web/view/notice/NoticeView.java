package com.ramyunmoa.web.view.notice;

import java.util.Date;

import com.ramyunmoa.web.entity.notice.Notice;

public class NoticeView extends Notice {
	private int cmtCount;

	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int id, String title, String writerId, Date regdate, int hit,	boolean pub, int cmtCount) {

		super(id, title, null, writerId, regdate, hit, pub);
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
		return "NoticeView [cmtCount=" + cmtCount + "]";
	}

	

}
