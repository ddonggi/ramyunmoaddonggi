package com.ramyunmoa.web.view.recipe;

import java.util.Date;

public class RecipeListView {
	
	private int id;
	private int writerId;
	private int hit;
	private int productId;
	private String mfcProduct;
	private String title;
	private String nickname;
	private int likes;
	private Date regdate;
	private String logo;
	private String img;
	private int cmtCount;

	
	public RecipeListView(int id, int writerId, int hit, int productId, String mfcProduct, String title,
			String nickname, int likes, Date regdate, String logo, String img, int cmtCount) {
		this.id = id;
		this.writerId = writerId;
		this.hit = hit;
		this.productId = productId;
		this.mfcProduct = mfcProduct;
		this.title = title;
		this.nickname = nickname;
		this.likes = likes;
		this.regdate = regdate;
		this.logo = logo;
		this.img = img;
		this.cmtCount = cmtCount;
	}


	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getMfcProduct() {
		return mfcProduct;
	}


	public void setMfcProduct(String mfcProduct) {
		this.mfcProduct = mfcProduct;
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


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
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
		return "RecipeListView [id=" + id + ", writerId=" + writerId + ", hit=" + hit + ", productId=" + productId
				+ ", mfcProduct=" + mfcProduct + ", title=" + title + ", nickname=" + nickname + ", likes=" + likes
				+ ", regdate=" + regdate + ", logo=" + logo + ", img=" + img + ", cmtCount=" + cmtCount + "]";
	}

}
