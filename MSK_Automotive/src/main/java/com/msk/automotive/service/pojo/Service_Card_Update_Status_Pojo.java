package com.msk.automotive.service.pojo;

public class Service_Card_Update_Status_Pojo {

	private String invoice_no;
	private String customer_id;
	private String model_id;
	private String name;
	private String mobile;
	private String registration_no;
	private String engine_no;
	private String policy_expires_date;
	private String gst_no;
	private String address_line;
	private String city;
	private String pincode;

	public Service_Card_Update_Status_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service_Card_Update_Status_Pojo(String invoice_no, String customer_id, String name, String mobile, String registration_no,
			String engine_no, String policy_expires_date, String gst_no, String address_line, String city,
			String pincode) {
		super();
		this.invoice_no = invoice_no;
		this.customer_id = customer_id;
		this.name = name;
		this.mobile = mobile;
		this.registration_no = registration_no;
		this.engine_no = engine_no;
		this.policy_expires_date = policy_expires_date;
		this.gst_no = gst_no;
		this.address_line = address_line;
		this.city = city;
		this.pincode = pincode;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public String getPolicy_expires_date() {
		return policy_expires_date;
	}

	public void setPolicy_expires_date(String policy_expires_date) {
		this.policy_expires_date = policy_expires_date;
	}

	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public String getAddress_line() {
		return address_line;
	}

	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	@Override
	public String toString() {
		return "Service_Card_Pojo [invoice_no=" + invoice_no + ", customer_id=" + customer_id + ", model_id=" + model_id
				+ ", name=" + name + ", mobile=" + mobile + ", registration_no=" + registration_no + ", engine_no="
				+ engine_no + ", policy_expires_date=" + policy_expires_date + ", gst_no=" + gst_no + ", address_line="
				+ address_line + ", city=" + city + ", pincode=" + pincode + "]";
	}

}