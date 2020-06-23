package com.ramyunmoa.web.view.review;

public class MfcProductView {
	private int id;
	private String mfcName;
	private String productName;
	private String mfcProduct;
	private String img;
	private String logo;
	
	public MfcProductView() {
		// TODO Auto-generated constructor stub
	}
	
	public MfcProductView(int id,String mfcName, String productName, String mfcProduct,String img,String logo) {
		this.id=id;
		this.mfcName=mfcName;
		this.productName=productName;
		this.mfcProduct=mfcProduct;
		this.img=img;
		this.logo=logo;
	}
	
	
	
	public MfcProductView(int id) {
		this.id=id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMfcName() {
		return mfcName;
	}
	public void setMfcName(String mfcName) {
		this.mfcName = mfcName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMfcProduct() {
		return mfcProduct;
	}
	public void setMfcProduct(String mfcProduct) {
		this.mfcProduct = mfcProduct;
	}


	@Override
	public String toString() {
		return "MfcProductView [id=" + id + ", mfcName=" + mfcName + ", productName=" + productName + ", mfcProduct="
				+ mfcProduct + ", img=" + img + ", logo=" + logo + "]";
	}
	
	
	
	
}
