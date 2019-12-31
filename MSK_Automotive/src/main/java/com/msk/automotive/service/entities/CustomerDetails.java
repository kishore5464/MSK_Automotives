package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "customerDetails")
public class CustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String customerId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private Date dob;
	private String registrationNo;
	private String engineNo;
	private Date policyExpiresDate;
	private String gstNo;
	private Date createdDate;

	private CarModels carModels;

	private Set<CustomerContactDetails> customerContactDetails = new HashSet<CustomerContactDetails>();
	private Set<ServiceInvoiceCard> serviceInvoiceCards = new HashSet<ServiceInvoiceCard>();
	private Set<PartsStockMaintain> partsStockMaintains = new HashSet<PartsStockMaintain>();

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(Integer id, CarModels carModels, String customerId, String firstName, String lastName,
			String mobile, String email, Date dob, String registrationNo, String engineNo, Date policyExpiresDate,
			String gstNo, Date createdDate, Set<CustomerContactDetails> customerContactDetails,
			Set<ServiceInvoiceCard> serviceInvoiceCards) {
		super();
		this.id = id;
		this.carModels = carModels;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.registrationNo = registrationNo;
		this.engineNo = engineNo;
		this.policyExpiresDate = policyExpiresDate;
		this.gstNo = gstNo;
		this.createdDate = createdDate;
		this.customerContactDetails = customerContactDetails;
		this.serviceInvoiceCards = serviceInvoiceCards;
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

	@Column(name = "customerId", nullable = false)
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name = "firstName", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Column(name = "registrationNo")
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Column(name = "gstNo", nullable = true)
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(name = "engineNo")
	public String getengineNo() {
		return engineNo;
	}

	public void setengineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "policyExpiresDate")
	public Date getpolicyExpiresDate() {
		return policyExpiresDate;
	}

	public void setpolicyExpiresDate(Date policyExpiresDate) {
		this.policyExpiresDate = policyExpiresDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDetails", cascade = CascadeType.ALL)
	public Set<CustomerContactDetails> getCustomerContactDetails() {
		return customerContactDetails;
	}

	public void setCustomerContactDetails(Set<CustomerContactDetails> customerContactDetails) {
		this.customerContactDetails = customerContactDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDetails", cascade = CascadeType.ALL)
	public Set<ServiceInvoiceCard> getServiceInvoiceCards() {
		return serviceInvoiceCards;
	}

	public void setServiceInvoiceCards(Set<ServiceInvoiceCard> serviceInvoiceCards) {
		this.serviceInvoiceCards = serviceInvoiceCards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDetails", cascade = CascadeType.ALL)
	public Set<PartsStockMaintain> getPartsStockMaintains() {
		return partsStockMaintains;
	}

	public void setPartsStockMaintains(Set<PartsStockMaintain> partsStockMaintains) {
		this.partsStockMaintains = partsStockMaintains;
	}

}
