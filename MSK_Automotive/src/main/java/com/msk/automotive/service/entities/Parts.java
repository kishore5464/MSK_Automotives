package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "parts")
public class Parts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private CarModels carModels;
	private String part;
	private Integer quantity;
	private StockStatus partsStatus;
	private Double amount;
	private Date createdDate;

	private Set<PartsStockMaintain> partsStockMaintains = new HashSet<PartsStockMaintain>();

	public Parts() {
		super();
	}

	public Parts(Integer id, CarModels carModels, String part, Integer quantity, StockStatus partsStatus,
			Double amount, Date createdDate) {
		super();
		this.id = id;
		this.carModels = carModels;
		this.part = part;
		this.quantity = quantity;
		this.setPartsStatus(partsStatus);
		this.amount = amount;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "carModelsId")
	public CarModels getCarModels() {
		return carModels;
	}

	public void setCarModels(CarModels carModels) {
		this.carModels = carModels;
	}

	@Column(name = "part")
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "partsStatus")
	public StockStatus getPartsStatus() {
		return partsStatus;
	}

	public void setPartsStatus(StockStatus partsStatus) {
		this.partsStatus = partsStatus;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "amount")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parts", cascade = CascadeType.ALL)
	public Set<PartsStockMaintain> getPartsStockMaintains() {
		return partsStockMaintains;
	}

	public void setPartsStockMaintains(Set<PartsStockMaintain> partsStockMaintains) {
		this.partsStockMaintains = partsStockMaintains;
	}

}
