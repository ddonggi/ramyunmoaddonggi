package com.ramyunmoa.web.view.product;

public class NutritionView {

	private int id;
	private String name;
	private String img;
	private int kcal;
	private int capacity;
	private int natrium;
	private int carbohydrate;
	private int sugars;
	private int fat;
	private int transfat;
	private int saturatedFat;
	private int cholesterol;
	private int protein;

	public NutritionView(int natrium, int carbohydrate, int sugars, int fat, int transfat, int saturatedFat,
			int cholesterol, int protein) {
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;
	}

	public NutritionView(int id, String name, String img, int kcal, int capacity, int natrium, int carbohydrate,
			int sugars, int fat, int transfat, int saturatedFat, int cholesterol, int protein) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.kcal = kcal;
		this.capacity = capacity;
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	@Override
	public String toString() {
		return "NutritionView [id=" + id + ", name=" + name + ", img=" + img + ", kcal=" + kcal + ", capacity="
				+ capacity + ", natrium=" + natrium + ", carbohydrate=" + carbohydrate + ", sugars=" + sugars + ", fat="
				+ fat + ", transfat=" + transfat + ", saturatedFat=" + saturatedFat + ", cholesterol=" + cholesterol
				+ ", protein=" + protein + "]";
	}

}
