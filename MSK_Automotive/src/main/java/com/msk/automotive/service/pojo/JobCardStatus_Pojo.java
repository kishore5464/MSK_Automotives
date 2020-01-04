package com.msk.automotive.service.pojo;

public class JobCardStatus_Pojo {

	private String jobCardId;
	private String brand;
	private String model;
	private String customerName;
	private String customerMobile;
	private String registrationNo;
	private String serviceType;
	private String totalAmount;
	private String serviceDate;
	private String cardStatus;

	public JobCardStatus_Pojo() {
		super();
	}

	public JobCardStatus_Pojo(String jobCardId, String brand, String model, String customerName, String customerMobile,
			String registrationNo, String serviceType, String totalAmount, String serviceDate, String cardStatus) {
		super();
		this.jobCardId = jobCardId;
		this.brand = brand;
		this.model = model;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.registrationNo = registrationNo;
		this.serviceType = serviceType;
		this.totalAmount = totalAmount;
		this.serviceDate = serviceDate;
		this.cardStatus = cardStatus;
	}

	public String getJobCardId() {
		return jobCardId;
	}

	public void setJobCardId(String jobCardId) {
		this.jobCardId = jobCardId;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Override
	public String toString() {
		return "JobCardStatus_Pojo [jobCardId=" + jobCardId + ", brand=" + brand + ", model=" + model
				+ ", customerName=" + customerName + ", customerMobile=" + customerMobile + ", registrationNo="
				+ registrationNo + ", serviceType=" + serviceType + ", totalAmount=" + totalAmount + ", serviceDate="
				+ serviceDate + ", cardStatus=" + cardStatus + "]";
	}

}
