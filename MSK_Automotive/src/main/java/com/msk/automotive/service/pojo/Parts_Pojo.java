package com.msk.automotive.service.pojo;

public class Parts_Pojo {

	private String brand_id;
	private String brand;
	private String logo;

	public Parts_Pojo() {
		super();
	}

	public Parts_Pojo(String brand_id, String brand, String logo) {
		super();
		this.brand_id = brand_id;
		this.brand = brand;
		this.logo = logo;
	}

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "UICar_Brands [brand_id=" + brand_id + ", brand=" + brand + ", logo=" + logo + "]";
	}

}
