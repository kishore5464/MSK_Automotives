package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_contact_details")
public class CustomerContactDetails implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private CustomerDetails customer_Details;
	private String address_line_1;
	private String address_line_2;
	private Location location;
	private Integer pincode;
	private Date created_date;

	public CustomerContactDetails() {
		super();
	}

	public CustomerContactDetails(Integer id, CustomerDetails customer_Details, String address_line_1,
			String address_line_2, Location location, Integer pincode, Date created_date) {
		super();
		this.id = id;
		this.customer_Details = customer_Details;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.location = location;
		this.pincode = pincode;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_details_id")
	public CustomerDetails getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(CustomerDetails customer_Details) {
		this.customer_Details = customer_Details;
	}

	@Column(name = "address_line_1", nullable = false)
	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	@Column(name = "address_line_2", nullable = true)
	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "pincode")
	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
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
