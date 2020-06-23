package com.ramyunmoa.web.view.review;

import java.util.Date;

public class ReviewDetailView {
	private int id;
	private String title;
	private String mfcProduct;
	private Date regdate;
	private String writerName;
	private int hit;
	private int likes;
	private String content;
	private int gradeId;
	private String gdContent;
	private int cmtCount;
	
	public ReviewDetailView() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewDetailView(int id, String title, String mfcProduct, Date regdate, String writerName, int hit, int likes,
			String content, int gradeId, String gdContent,int cmtCount) {
		this.id = id;
		this.title = title;
		this.mfcProduct = mfcProduct;
		this.regdate = regdate;
		this.writerName= writerName;
		this.hit = hit;
		this.likes = likes;
		this.content = content;
		this.gradeId = gradeId;
		this.gdContent = gdContent;
		this.cmtCount=cmtCount;
	}
	
	
	
	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMfcProduct() {
		return mfcProduct;
	}
	public void setMfcProduct(String mfcProduct) {
		this.mfcProduct = mfcProduct;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGdContent() {
		return gdContent;
	}
	public void setGdContent(String gdContent) {
		this.gdContent = gdContent;
	}
	@Override
	public String toString() {
		return "ReviewDetailView [id=" + id + ", title=" + title + ", mfcProduct=" + mfcProduct + ", regdate=" + regdate
				+ ", writerName=" + writerName + ", hit=" + hit + ", likes=" + likes + ", content=" + content
				+ ", gradeId=" + gradeId + ", gdContent=" + gdContent + ", cmtCount=" + cmtCount + "]";
	}
	
	
}
