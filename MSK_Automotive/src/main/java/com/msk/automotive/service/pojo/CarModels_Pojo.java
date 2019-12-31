package com.msk.automotive.service.pojo;

public class CarModels_Pojo {

	private String brand_id;
	private String model_id;
	private String model;
	private String image;

	public CarModels_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarModels_Pojo(String brand_id, String model_id, String model, String image) {
		super();
		this.brand_id = brand_id;
		this.model_id = model_id;
		this.model = model;
		this.image = image;
	}

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
