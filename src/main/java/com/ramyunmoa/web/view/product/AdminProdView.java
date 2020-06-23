package com.ramyunmoa.web.view.product;

public class AdminProdView {

	private int id;
	private String name;
	private int capacity;
	private int kcal;
	private int natrium;
	private int carbohydrate;
	private int sugars;
	private int fat;
	private int transfat;
	private int saturatedFat;
	private int cholesterol;
	private int protein;
	private String mfr;
	private int mfrId;
	private int amount;
	private int year;
	private int quarter;
	private String img;

	public AdminProdView(int id, String name, int capacity, int kcal, int natrium, int carbohydrate, int sugars,
			int fat, int transfat, int saturatedFat, int cholesterol, int protein, String mfr, int amount, int year,
			int quarter, String img) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.kcal = kcal;
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;
		this.mfr = mfr;
		this.amount = amount;
		this.year = year;
		this.quarter = quarter;
		this.img = img;
	}

	public AdminProdView(String name, int capacity, int kcal, int mfrId, String img, int amount, int year, int quarter,
			int natrium, int carbohydrate, int sugars, int fat, int transfat, int saturatedFat, int cholesterol,
			int protein) {
		this.name = name;
		this.capacity = capacity;
		this.kcal = kcal;
		this.mfrId = mfrId;
		this.img = img;
		this.amount = amount;
		this.year = year;
		this.quarter = quarter;
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;

	}

	public AdminProdView(int id, String name, int capacity, int kcal, int natrium, int carbohydrate, int sugars,
			int fat, int transfat, int saturatedFat, int cholesterol, int protein, String mfr, int mfrId, int amount,
			int year, int quarter, String img) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.kcal = kcal;
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;
		this.mfr = mfr;
		this.mfrId = mfrId;
		this.amount = amount;
		this.year = year;
		this.quarter = quarter;
		this.img = img;

	}

	public int getMfrId() {
		return mfrId;
	}

	public void setMfrId(int mfrId) {
		this.mfrId = mfrId;
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

	public int getNatrium() {
		return natrium;
	}

	public void setNatrium(int natrium) {
		this.natrium = natrium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public int getSugars() {
		return sugars;
	}

	public void setSugars(int sugars) {
		this.sugars = sugars;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getTransfat() {
		return transfat;
	}

	public void setTransfat(int transfat) {
		this.transfat = transfat;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "AdminProdView [id=" + id + ", name=" + name + ", capacity=" + capacity + ", kcal=" + kcal + ", natrium="
				+ natrium + ", carbohydrate=" + carbohydrate + ", sugars=" + sugars + ", fat=" + fat + ", transfat="
				+ transfat + ", saturatedFat=" + saturatedFat + ", cholesterol=" + cholesterol + ", protein=" + protein
				+ ", mfr=" + mfr + ", mfrId=" + mfrId + ", amount=" + amount + ", year=" + year + ", quarter=" + quarter
				+ ", img=" + img + ", getMfrId()=" + getMfrId() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getCapacity()=" + getCapacity() + ", getKcal()=" + getKcal() + ", getNatrium()=" + getNatrium()
				+ ", getCarbohydrate()=" + getCarbohydrate() + ", getSugars()=" + getSugars() + ", getFat()=" + getFat()
				+ ", getTransfat()=" + getTransfat() + ", getSaturatedFat()=" + getSaturatedFat()
				+ ", getCholesterol()=" + getCholesterol() + ", getProtein()=" + getProtein() + ", getMfr()=" + getMfr()
				+ ", getAmount()=" + getAmount() + ", getYear()=" + getYear() + ", getQuarter()=" + getQuarter()
				+ ", getImg()=" + getImg() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
