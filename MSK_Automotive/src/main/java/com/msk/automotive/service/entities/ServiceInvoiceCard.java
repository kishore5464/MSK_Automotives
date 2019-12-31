package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "serviceInvoiceCard")
public class ServiceInvoiceCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String serviceId;

	private CustomerDetails customerDetails;
	private ServiceType serviceType;
	private ServiceAdvisor serviceAdviser;

	private String serviceDetail;
	private String toolKit;
	private String spareWheel;
	private String jack;
	private String jackHandler;
	private String carPerfume;
	private String clock;
	private String cdPlayer;
	private Integer kilometer;
	private CardType cardType;
	private CardStatus cardStatus;
	private Date currentServiceDate;
	private Date serviceExpireDate;
	private Double totalAmount;
	private Date createdDate;

	public ServiceInvoiceCard() {
		super();
	}

	public ServiceInvoiceCard(Integer id, String serviceId, CustomerDetails customerDetails,
			ServiceType serviceType, ServiceAdvisor serviceAdviser, String serviceDetail, String toolKit,
			String spareWheel, String jack, String jackHandler, String carPerfume, String clock, String cdPlayer,
			Integer kilometer, CardType cardType, CardStatus cardStatus, Date currentServiceDate,
			Date serviceExpireDate, Double totalAmount, Date createdDate) {
		super();
		this.id = id;
		this.serviceId = serviceId;
		this.customerDetails = customerDetails;
		this.serviceType = serviceType;
		this.serviceAdviser = serviceAdviser;
		this.serviceDetail = serviceDetail;
		this.toolKit = toolKit;
		this.spareWheel = spareWheel;
		this.jack = jack;
		this.jackHandler = jackHandler;
		this.carPerfume = carPerfume;
		this.clock = clock;
		this.cdPlayer = cdPlayer;
		this.kilometer = kilometer;
		this.cardType = cardType;
		this.cardStatus = cardStatus;
		this.currentServiceDate = currentServiceDate;
		this.serviceExpireDate = serviceExpireDate;
		this.totalAmount = totalAmount;
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

	@Column(name = "serviceId", nullable = false, unique = true)
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerDetailsId", nullable = false)
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "servicesTypeId")
	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "serviceAdviserId")
	public ServiceAdvisor getServiceAdviser() {
		return serviceAdviser;
	}

	public void setServiceAdviser(ServiceAdvisor serviceAdviser) {
		this.serviceAdviser = serviceAdviser;
	}

	@Column(name = "serviceDetail")
	public String getServiceDetail() {
		return serviceDetail;
	}

	public void setServiceDetail(String serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	@Column(name = "toolKit")
	public String getToolKit() {
		return toolKit;
	}

	public void setToolKit(String toolKit) {
		this.toolKit = toolKit;
	}

	@Column(name = "spareWheel")
	public String getSpareWheel() {
		return spareWheel;
	}

	public void setSpareWheel(String spareWheel) {
		this.spareWheel = spareWheel;
	}

	@Column(name = "jack")
	public String getJack() {
		return jack;
	}

	public void setJack(String jack) {
		this.jack = jack;
	}

	@Column(name = "jackHandler")
	public String getJackHandler() {
		return jackHandler;
	}

	public void setJackHandler(String jackHandler) {
		this.jackHandler = jackHandler;
	}

	@Column(name = "carPerfume")
	public String getCarPerfume() {
		return carPerfume;
	}

	public void setCarPerfume(String carPerfume) {
		this.carPerfume = carPerfume;
	}

	@Column(name = "clock")
	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	@Column(name = "cdPlayer")
	public String getCdPlayer() {
		return cdPlayer;
	}

	public void setCdPlayer(String cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	@Column(name = "kilometer")
	public Integer getKilometer() {
		return kilometer;
	}

	public void setKilometer(Integer kilometer) {
		this.kilometer = kilometer;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cardType")
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cardStatus")
	public CardStatus getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "currentServiceDate")
	public Date getCurrentServiceDate() {
		return currentServiceDate;
	}

	public void setCurrentServiceDate(Date currentServiceDate) {
		this.currentServiceDate = currentServiceDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "serviceExpireDate")
	public Date getServiceExpireDate() {
		return serviceExpireDate;
	}

	public void setServiceExpireDate(Date serviceExpireDate) {
		this.serviceExpireDate = serviceExpireDate;
	}

	@Column(name = "totalAmount")
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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