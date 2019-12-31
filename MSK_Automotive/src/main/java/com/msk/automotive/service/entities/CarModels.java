package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "carModels")
public class CarModels implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private CarBrands carBrands;
	private String model;
	private String image;
	private Date createdDate;

	private Set<CustomerDetails> customerDetails = new HashSet<CustomerDetails>();
	private Set<Parts> parts = new HashSet<Parts>();
	private Set<PartsStockMaintain> partsStockMaintains = new HashSet<PartsStockMaintain>();

	public CarModels() {
		super();
	}

	public CarModels(Integer id, CarBrands carBrands, String model, String image, Date createdDate) {
		super();
		this.id = id;
		this.carBrands = carBrands;
		this.model = model;
		this.image = image;
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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "carBrandsId")
	public CarBrands getCarBrands() {
		return carBrands;
	}

	public void setCarBrands(CarBrands carBrands) {
		this.carBrands = carBrands;
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
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany
	@JoinColumn(name = "carModelsId")
	public Set<CustomerDetails> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Set<CustomerDetails> customerDetails) {
		this.customerDetails = customerDetails;
	}

	@OneToMany
	@JoinColumn(name = "carModelsId")
	public Set<Parts> getParts() {
		return parts;
	}

	public void setParts(Set<Parts> parts) {
		this.parts = parts;
	}

	@OneToMany
	@JoinColumn(name = "carModelsId")
	public Set<PartsStockMaintain> getPartsStockMaintains() {
		return partsStockMaintains;
	}

	public void setPartsStockMaintains(Set<PartsStockMaintain> partsStockMaintains) {
		this.partsStockMaintains = partsStockMaintains;
	}

}
