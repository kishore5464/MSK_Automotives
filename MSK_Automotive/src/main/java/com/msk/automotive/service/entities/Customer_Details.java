package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_details")
public class Customer_Details implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Car_Models car_Models;
	private String customer_id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String email;
	private Date dob;
	private String registration_no;
	private String engine_no;
	private Date policy_expires_date;
	private String gst_no;
	private Date created_date;

	private Set<Customer_Contact_Details> customer_Contact_Details = new HashSet<Customer_Contact_Details>();
	private Set<Service_Invoice_Card> service_Invoice_Cards = new HashSet<Service_Invoice_Card>();
	private Set<Parts_Stock_Maintain> parts_Stock_Maintains = new HashSet<Parts_Stock_Maintain>();

	public Customer_Details() {
		super();
	}

	public Customer_Details(Integer id, Car_Models car_Models, String customer_id, String first_name, String last_name,
			String mobile, String email, Date dob, String registration_no, String engine_no, Date policy_expires_date,
			String gst_no, Date created_date, Set<Customer_Contact_Details> customer_Contact_Details,
			Set<Service_Invoice_Card> service_Invoice_Cards) {
		super();
		this.id = id;
		this.car_Models = car_Models;
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.registration_no = registration_no;
		this.engine_no = engine_no;
		this.setPolicy_expires_date(policy_expires_date);
		this.gst_no = gst_no;
		this.created_date = created_date;
		this.customer_Contact_Details = customer_Contact_Details;
		this.service_Invoice_Cards = service_Invoice_Cards;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_models_id")
	public Car_Models getCar_Models() {
		return car_Models;
	}

	public void setCar_Models(Car_Models car_Models) {
		this.car_Models = car_Models;
	}

	@Column(name = "customer_id", nullable = false)
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column(name = "last_name", nullable = true)
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(name = "mobile", nullable = false)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = true)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "registration_no")
	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	@Column(name = "gst_no", nullable = true)
	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_Details")
	public Set<Customer_Contact_Details> getCustomer_Contact_Details() {
		return customer_Contact_Details;
	}

	public void setCustomer_Contact_Details(Set<Customer_Contact_Details> customer_Contact_Details) {
		this.customer_Contact_Details = customer_Contact_Details;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_Details")
	public Set<Service_Invoice_Card> getService_Invoice_Cards() {
		return service_Invoice_Cards;
	}

	public void setService_Invoice_Cards(Set<Service_Invoice_Card> service_Invoice_Cards) {
		this.service_Invoice_Cards = service_Invoice_Cards;
	}

	@Column(name = "engine_no")
	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "policy_expires_date")
	public Date getPolicy_expires_date() {
		return policy_expires_date;
	}

	public void setPolicy_expires_date(Date policy_expires_date) {
		this.policy_expires_date = policy_expires_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_Details")
	public Set<Parts_Stock_Maintain> getParts_Stock_Maintains() {
		return parts_Stock_Maintains;
	}

	public void setParts_Stock_Maintains(Set<Parts_Stock_Maintain> parts_Stock_Maintains) {
		this.parts_Stock_Maintains = parts_Stock_Maintains;
	}

}
