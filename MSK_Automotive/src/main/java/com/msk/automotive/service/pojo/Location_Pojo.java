package com.msk.automotive.service.pojo;

public class Location_Pojo {

	private String id;
	private String city;

	public Location_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location_Pojo(String id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location_Pojo [id=" + id + ", city=" + city + "]";
	}

}
