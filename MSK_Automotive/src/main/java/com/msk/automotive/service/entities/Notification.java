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
	private String customer_name;
	private Date dob;
	private String mobile;
	private String registration_no;
	private String car_brand;
	private String car_model;
	private Date service_expire_date;
	private Integer view_status;
	private Date created_date;

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Integer id, String customer_name, Date dob, String mobile, String car_brand, String car_model,
			Date service_expire_date, Integer view_status, Date created_date) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.dob = dob;
		this.mobile = mobile;
		this.car_brand = car_brand;
		this.car_model = car_model;
		this.service_expire_date = service_expire_date;
		this.view_status = view_status;
		this.created_date = created_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "customer_name")
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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

	@Column(name = "car_brand")
	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	@Column(name = "registration_no")
	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	@Column(name = "car_model")
	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_expire_date")
	public Date getService_expire_date() {
		return service_expire_date;
	}

	public void setService_expire_date(Date service_expire_date) {
		this.service_expire_date = service_expire_date;
	}

	@Column(name = "view_status")
	public Integer getView_status() {
		return view_status;
	}

	public void setView_status(Integer view_status) {
		this.view_status = view_status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}