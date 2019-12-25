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
@Table(name = "parts_stock_maintain")
public class Parts_Stock_Maintain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer original_quantity;
	private Integer customer_quantity;
	private Integer available_quantity;
	private Double original_amount;
	private Double customer_amount;
	private Double difference_amount;

	private Parts parts;
	private Customer_Details customer_Details;
	private Car_Models car_Models;

	private Date created_date;

	public Parts_Stock_Maintain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parts_Stock_Maintain(Integer id, Integer original_quantity, Integer customer_quantity,
			Integer available_quantity, Double original_amount, Double customer_amount, Double difference_amount,
			Parts parts, Customer_Details customer_Details, Car_Models car_Models, Date created_date) {
		super();
		this.id = id;
		this.original_quantity = original_quantity;
		this.customer_quantity = customer_quantity;
		this.available_quantity = available_quantity;
		this.original_amount = original_amount;
		this.customer_amount = customer_amount;
		this.difference_amount = difference_amount;
		this.parts = parts;
		this.customer_Details = customer_Details;
		this.car_Models = car_Models;
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

	@Column(name = "original_quantity")
	public Integer getOriginal_quantity() {
		return original_quantity;
	}

	public void setOriginal_quantity(Integer original_quantity) {
		this.original_quantity = original_quantity;
	}

	@Column(name = "customer_quantity")
	public Integer getCustomer_quantity() {
		return customer_quantity;
	}

	public void setCustomer_quantity(Integer customer_quantity) {
		this.customer_quantity = customer_quantity;
	}

	@Column(name = "available_quantity")
	public Integer getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(Integer available_quantity) {
		this.available_quantity = available_quantity;
	}

	@Column(name = "original_amount")
	public Double getOriginal_amount() {
		return original_amount;
	}

	public void setOriginal_amount(Double original_amount) {
		this.original_amount = original_amount;
	}

	@Column(name = "customer_amount")
	public Double getCustomer_amount() {
		return customer_amount;
	}

	public void setCustomer_amount(Double customer_amount) {
		this.customer_amount = customer_amount;
	}

	@Column(name = "difference_amount")
	public Double getDifference_amount() {
		return difference_amount;
	}

	public void setDifference_amount(Double difference_amount) {
		this.difference_amount = difference_amount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Customer_Details getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Customer_Details customer_Details) {
		this.customer_Details = customer_Details;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	public Car_Models getCar_Models() {
		return car_Models;
	}

	public void setCar_Models(Car_Models car_Models) {
		this.car_Models = car_Models;
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