package com.msk.automotive.service.pojo;

public class Service_Parts_Pojo {

	private String part_id;
	private String part;
	private String quantity;
	private String amount;

	public Service_Parts_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service_Parts_Pojo(String part_id, String part, String quantity, String amount) {
		super();
		this.part_id = part_id;
		this.part = part;
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Service_Parts_Pojo [part_id=" + part_id + ", part=" + part + ", quantity=" + quantity + ", amount="
				+ amount + "]";
	}

}