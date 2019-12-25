package com.msk.automotive.service.pojo;

import java.util.Comparator;
import java.util.Date;

public class Spare_Parts_Pojo implements Comparator<Spare_Parts_Pojo> {

	private String id;
	private String brand;
	private String model;
	private String spare_part_id;
	private String spare_part_name;
	private String quantity;
	private String price_per_unit;
	private String total_price;
	private Date created_date;

	public Spare_Parts_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Spare_Parts_Pojo(String id, String brand, String model, String spare_part_id, String spare_part_name,
			String quantity, String price_per_unit, String total_price, Date created_date) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.spare_part_id = spare_part_id;
		this.spare_part_name = spare_part_name;
		this.quantity = quantity;
		this.price_per_unit = price_per_unit;
		this.total_price = total_price;
		this.created_date = created_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSpare_part_name() {
		return spare_part_name;
	}

	public void setSpare_part_name(String spare_part_name) {
		this.spare_part_name = spare_part_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice_per_unit() {
		return price_per_unit;
	}

	public void setPrice_per_unit(String price_per_unit) {
		this.price_per_unit = price_per_unit;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getSpare_part_id() {
		return spare_part_id;
	}

	public void setSpare_part_id(String spare_part_id) {
		this.spare_part_id = spare_part_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Spare_Parts_Pojo [id=" + id + ", brand=" + brand + ", model=" + model + ", spare_part_id="
				+ spare_part_id + ", spare_part_name=" + spare_part_name + ", quantity=" + quantity
				+ ", price_per_unit=" + price_per_unit + ", total_price=" + total_price + ", created_date="
				+ created_date + "]";
	}

	@Override
	public int compare(Spare_Parts_Pojo spare1, Spare_Parts_Pojo spare2) {
		// TODO Auto-generated method stub
		return spare2.getCreated_date().compareTo(spare1.getCreated_date());
	}
}
