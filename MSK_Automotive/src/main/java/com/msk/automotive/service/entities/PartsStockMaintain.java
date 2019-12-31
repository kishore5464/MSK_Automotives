package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "partsStockMaintain")
public class PartsStockMaintain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer originalQuantity;
	private Integer customerQuantity;
	private Integer availableQuantity;
	private Double originalAmount;
	private Double customerAmount;
	private Double differenceAmount;

	private Parts parts;
	private CustomerDetails customerDetails;
	private CarModels carModels;

	private Date createdDate;

	public PartsStockMaintain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartsStockMaintain(Integer id, Integer originalQuantity, Integer customerQuantity,
			Integer availableQuantity, Double originalAmount, Double customerAmount, Double differenceAmount,
			Parts parts, CustomerDetails customerDetails, CarModels carModels, Date createdDate) {
		super();
		this.id = id;
		this.originalQuantity = originalQuantity;
		this.customerQuantity = customerQuantity;
		this.availableQuantity = availableQuantity;
		this.originalAmount = originalAmount;
		this.customerAmount = customerAmount;
		this.differenceAmount = differenceAmount;
		this.parts = parts;
		this.customerDetails = customerDetails;
		this.carModels = carModels;
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

	@Column(name = "originalQuantity")
	public Integer getOriginalQuantity() {
		return originalQuantity;
	}

	public void setOriginalQuantity(Integer originalQuantity) {
		this.originalQuantity = originalQuantity;
	}

	@Column(name = "customerQuantity")
	public Integer getCustomerQuantity() {
		return customerQuantity;
	}

	public void setCustomerQuantity(Integer customerQuantity) {
		this.customerQuantity = customerQuantity;
	}

	@Column(name = "availableQuantity")
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name = "originalAmount")
	public Double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}

	@Column(name = "customerAmount")
	public Double getCustomerAmount() {
		return customerAmount;
	}

	public void setCustomerAmount(Double customerAmount) {
		this.customerAmount = customerAmount;
	}

	@Column(name = "differenceAmount")
	public Double getDifferenceAmount() {
		return differenceAmount;
	}

	public void setDifferenceAmount(Double differenceAmount) {
		this.differenceAmount = differenceAmount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "partId")
	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "modelId")
	public CarModels getCarModels() {
		return carModels;
	}

	public void setCarModels(CarModels carModels) {
		this.carModels = carModels;
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