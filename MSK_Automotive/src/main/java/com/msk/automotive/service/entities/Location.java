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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "location")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String city;
	private Date created_date;

	private Set<CustomerContactDetails> customer_Contact_Details = new HashSet<CustomerContactDetails>();

	public Location() {
		super();
	}

	public Location(Integer id, String city, Date created_date) {
		super();
		this.id = id;
		this.city = city;
		this.created_date = created_date;
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

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	public Set<CustomerContactDetails> getCustomer_Contact_Details() {
		return customer_Contact_Details;
	}

	public void setCustomer_Contact_Details(Set<CustomerContactDetails> customer_Contact_Details) {
		this.customer_Contact_Details = customer_Contact_Details;
	}

}
