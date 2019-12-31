package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notification")
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String customerName;
	private Date dob;
	private String mobile;
	private String registrationNo;
	private String carBrand;
	private String carModel;
	private Date serviceExpireDate;
	private Integer viewStatus;
	private Date createdDate;

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Integer id, String customerName, Date dob, String mobile, String carBrand, String carModel,
			Date serviceExpireDate, Integer viewStatus, Date createdDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.dob = dob;
		this.mobile = mobile;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.serviceExpireDate = serviceExpireDate;
		this.viewStatus = viewStatus;
		this.createdDate = createdDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "customerName")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "carBrand")
	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	@Column(name = "registrationNo")
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Column(name = "carModel")
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "serviceExpireDate")
	public Date getServiceExpireDate() {
		return serviceExpireDate;
	}

	public void setServiceExpireDate(Date serviceExpireDate) {
		this.serviceExpireDate = serviceExpireDate;
	}

	@Column(name = "viewStatus")
	public Integer getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(Integer viewStatus) {
		this.viewStatus = viewStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}