package com.ramyunmoa.web.view.product;

public class ProductView {

	private int id;
	private String name;
	private int capacity;
	private int kcal;
	private String mfr;
	private String img;
	private String details;

	public ProductView(int id, String name, int capacity, int kcal, String mfr, String img, String details) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.kcal = kcal;
		this.mfr = mfr;
		this.img = img;
		this.details = details;
	}

	public ProductView(int id, String name, String mfr, String img) {
		this.id = id;
		this.name = name;
		this.mfr = mfr;
		this.img = img;
	}

	public ProductView(int id, String name, int kcal, String mfr) {
		this.id=id;
		this.name=name;
		this.kcal=kcal;
		this.mfr=mfr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ProductView [id=" + id + ", name=" + name + ", capacity=" + capacity + ", kcal=" + kcal + ", mfr=" + mfr
				+ ", img=" + img + ", details=" + details + "]";
	}

}
