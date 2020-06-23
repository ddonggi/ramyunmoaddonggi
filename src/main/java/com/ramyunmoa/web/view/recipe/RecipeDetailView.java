package com.ramyunmoa.web.view.recipe;

import java.util.Date;

public class RecipeDetailView {
	private int id;
	private String title;
	private String mfcProduct;
	private Date regdate;
	private String writerName;
	private int hit;
	private int likes;
	private String content;
	private int cmtCount;
	
	
	
	public RecipeDetailView(int id, String title, String mfcProduct, Date regdate, String writerName, int hit,
			int likes, String content, int cmtCount) {
		this.id = id;
		this.title = title;
		this.mfcProduct = mfcProduct;
		this.regdate = regdate;
		this.writerName = writerName;
		this.hit = hit;
		this.likes = likes;
		this.content = content;
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
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	@Override
	public String toString() {
		return "RecipeDetailView [id=" + id + ", title=" + title + ", mfcProduct=" + mfcProduct + ", regdate=" + regdate
				+ ", writerName=" + writerName + ", hit=" + hit + ", likes=" + likes + ", content=" + content
				+ ", cmtCount=" + cmtCount + "]";
	}

	
	
}