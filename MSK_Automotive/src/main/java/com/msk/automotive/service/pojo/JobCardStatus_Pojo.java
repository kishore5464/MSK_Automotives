package com.msk.automotive.service.pojo;

public class JobCardStatus_Pojo {

	private String job_card_id;
	private String brand;
	private String model;
	private String customer_name;
	private String customer_mobile;
	private String registration_no;
	private String service_type;
	private String total_amount;
	private String service_date;
	private String card_status;

	public JobCardStatus_Pojo() {
		super();
	}

	public JobCardStatus_Pojo(String job_card_id, String brand, String model, String customer_name,
			String customer_mobile, String registration_no, String service_type, String total_amount,
			String service_date, String card_status) {
		super();
		this.job_card_id = job_card_id;
		this.brand = brand;
		this.model = model;
		this.customer_name = customer_name;
		this.customer_mobile = customer_mobile;
		this.registration_no = registration_no;
		this.service_type = service_type;
		this.total_amount = total_amount;
		this.service_date = service_date;
		this.card_status = card_status;
	}

	public String getJob_card_id() {
		return job_card_id;
	}

	public void setJob_card_id(String job_card_id) {
		this.job_card_id = job_card_id;
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

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getService_date() {
		return service_date;
	}

	public void setService_date(String service_date) {
		this.service_date = service_date;
	}

	public String getCard_status() {
		return card_status;
	}

	public void setCard_status(String card_status) {
		this.card_status = card_status;
	}

	@Override
	public String toString() {
		return "Job_Card_Status_Pojo [job_card_id=" + job_card_id + ", brand=" + brand + ", model=" + model
				+ ", customer_name=" + customer_name + ", customer_mobile=" + customer_mobile + ", registration_no="
				+ registration_no + ", service_type=" + service_type + ", total_amount=" + total_amount
				+ ", service_date=" + service_date + ", card_status=" + card_status + "]";
	}

}
