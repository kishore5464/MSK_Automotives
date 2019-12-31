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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "serviceType")
public class ServiceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String serviceType;
	private String commonService;
	private Date createdDate;

	private Set<ServiceInvoiceCard> serviceInvoiceCards = new HashSet<ServiceInvoiceCard>();

	public ServiceType() {
		super();
	}

	public ServiceType(Integer id, String serviceType, String commonService, Date createdDate,
			Set<ServiceInvoiceCard> serviceInvoiceCards) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.commonService = commonService;
		this.createdDate = createdDate;
		this.setServiceInvoiceCards(serviceInvoiceCards);
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

	@Column(name = "serviceType")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "commonService")
	public String getCommonService() {
		return commonService;
	}

	public void setCommonService(String commonService) {
		this.commonService = commonService;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceType", cascade = CascadeType.ALL)
	public Set<ServiceInvoiceCard> getServiceInvoiceCards() {
		return serviceInvoiceCards;
	}

	public void setServiceInvoiceCards(Set<ServiceInvoiceCard> serviceInvoiceCards) {
		this.serviceInvoiceCards = serviceInvoiceCards;
	}

}
