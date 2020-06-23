package com.ramyunmoa.web.view.review;

import java.util.Date;

public class ReviewListView {
	private int id;
	private int writerId;
	private String mfcProduct;
	private int gradeId;
	private String title;
	private String nickname;
	private Date regdate;
	private String logo;
	private String img;
	private int cmtCount;

	public ReviewListView() {
		// TODO Auto-generated constructor stub
	}
	

	public ReviewListView(int id,int writerId, String mfcProduct,int gradeId, String title, String nickname, Date regdate, String logo,
			String img,int cmtCount) {
		this.id=id;
		this.writerId = writerId;
		this.mfcProduct = mfcProduct;
		this.gradeId=gradeId;
		this.title = title;
		this.nickname = nickname;
		this.regdate = regdate;
		this.logo = logo;
		this.img = img;
		this.cmtCount = cmtCount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getWriterId() {
		return writerId;
	}


	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}


	public String getMfcProduct() {
		return mfcProduct;
	}


	public void setMfcProduct(String mfcProduct) {
		this.mfcProduct = mfcProduct;
	}


	public int getGradeId() {
		return gradeId;
	}


	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getCmtCount() {
		return cmtCount;
	}


	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}


	@Override
	public String toString() {
		return "ReviewListView [id=" + id + ", writerId=" + writerId + ", mfcProduct=" + mfcProduct + ", gradeId="
				+ gradeId + ", title=" + title + ", nickname=" + nickname + ", regdate=" + regdate + ", logo=" + logo
				+ ", img=" + img + ", cmtCount=" + cmtCount + "]";
	}

	
	
	
	
	
	
}
