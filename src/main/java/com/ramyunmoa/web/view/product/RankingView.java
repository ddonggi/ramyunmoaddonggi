package com.ramyunmoa.web.view.product;

public class RankingView {

	private int id;
	private String name;
	private int mfrId;
	private int sales;
	private int year;
	private int quarter;
	private String logo;
	private String img;

	public RankingView(int id, String name, int mfrId, int sales, int year, int quarter, String logo, String img) {
		super();
		this.id = id;
		this.name = name;
		this.mfrId = mfrId;
		this.sales = sales;
		this.year = year;
		this.quarter = quarter;
		this.logo = logo;
		this.img = img;
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

	public int getMfrId() {
		return mfrId;
	}

	public void setMfrId(int mfrId) {
		this.mfrId = mfrId;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
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

	@Override
	public String toString() {
		return "RankingView [id=" + id + ", name=" + name + ", mfrId=" + mfrId + ", sales=" + sales + ", year=" + year
				+ ", quarter=" + quarter + ", logo=" + logo + ", img=" + img + "]";
	}

}
