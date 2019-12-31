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
@Table(name = "serviceAdviser")
public class ServiceAdvisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private MSKOwner mskOwner;
	private String name;
	private String mobile;
	private Date createdDate;

	private Set<ServiceInvoiceCard> serviceInvoiceCards = new HashSet<ServiceInvoiceCard>();

	public ServiceAdvisor() {
		super();
	}

	public ServiceAdvisor(Integer id, MSKOwner mskOwner, String name, String mobile, Date createdDate,
			Set<ServiceInvoiceCard> serviceInvoiceCards) {
		super();
		this.id = id;
		this.mskOwner = mskOwner;
		this.name = name;
		this.mobile = mobile;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "mskOwnerId")
	public MSKOwner getMskOwner() {
		return mskOwner;
	}

	public void setMskOwner(MSKOwner mskOwner) {
		this.mskOwner = mskOwner;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceAdviser", cascade = CascadeType.ALL)
	public Set<ServiceInvoiceCard> getServiceInvoiceCards() {
		return serviceInvoiceCards;
	}

	public void setServiceInvoiceCards(Set<ServiceInvoiceCard> serviceInvoiceCards) {
		this.serviceInvoiceCards = serviceInvoiceCards;
	}

}
