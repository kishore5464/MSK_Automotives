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
@Table(name = "car_models")
public class Car_Models implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Car_Brands car_Brands;
	private String model;
	private String image;
	private Date created_date;

	private Set<Customer_Details> customer_Details = new HashSet<Customer_Details>();
	private Set<Parts> parts = new HashSet<Parts>();
	private Set<Parts_Stock_Maintain> parts_Stock_Maintains = new HashSet<Parts_Stock_Maintain>();

	public Car_Models() {
		super();
	}

	public Car_Models(Integer id, Car_Brands car_Brands, String model, String image, Date created_date) {
		super();
		this.id = id;
		this.car_Brands = car_Brands;
		this.model = model;
		this.image = image;
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
	@JoinColumn(name = "car_brands_id")
	public Car_Brands getCar_Brands() {
		return car_Brands;
	}

	public void setCar_Brands(Car_Brands car_Brands) {
		this.car_Brands = car_Brands;
	}

	@Column(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car_Models")
	public Set<Customer_Details> getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Set<Customer_Details> customer_Details) {
		this.customer_Details = customer_Details;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car_Models")
	public Set<Parts> getParts() {
		return parts;
	}

	public void setParts(Set<Parts> parts) {
		this.parts = parts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car_Models")
	public Set<Parts_Stock_Maintain> getParts_Stock_Maintains() {
		return parts_Stock_Maintains;
	}

	public void setParts_Stock_Maintains(Set<Parts_Stock_Maintain> parts_Stock_Maintains) {
		this.parts_Stock_Maintains = parts_Stock_Maintains;
	}

}
