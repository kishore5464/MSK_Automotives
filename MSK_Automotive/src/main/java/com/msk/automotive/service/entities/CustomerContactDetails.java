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
@Table(name = "customerContactDetails")
public class CustomerContactDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String addressLine1;
	private String addressLine2;
	private Integer pincode;
	private Date createdDate;

	private CustomerDetails customerDetails;
	private Location location;

	public CustomerContactDetails() {
		super();
	}

	public CustomerContactDetails(Integer id, CustomerDetails customerDetails, String addressLine1, String addressLine2,
			Location location, Integer pincode, Date createdDate) {
		super();
		this.id = id;
		this.customerDetails = customerDetails;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.location = location;
		this.pincode = pincode;
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

	@Column(name = "addressLine1", nullable = false)
	public String getaddressLine1() {
		return addressLine1;
	}

	public void setaddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "addressLine2", nullable = true)
	public String getaddressLine2() {
		return addressLine2;
	}

	public void setaddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "pincode")
	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getcreatedDate() {
		return createdDate;
	}

	public void setcreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
}
