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
@Table(name = "service_type")
public class ServiceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String service_type;
	private String common_service;
	private Date created_date;

	private Set<ServiceInvoiceCard> service_Invoice_Cards = new HashSet<ServiceInvoiceCard>();

	public ServiceType() {
		super();
	}

	public ServiceType(Integer id, String service_type, String common_service, Date created_date,
			Set<ServiceInvoiceCard> service_Invoice_Cards) {
		super();
		this.id = id;
		this.service_type = service_type;
		this.common_service = common_service;
		this.created_date = created_date;
		this.setService_Invoice_Cards(service_Invoice_Cards);
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

	@Column(name = "service_type")
	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	@Column(name = "common_service")
	public String getCommon_service() {
		return common_service;
	}

	public void setCommon_service(String common_service) {
		this.common_service = common_service;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "service_Type")
	public Set<ServiceInvoiceCard> getService_Invoice_Cards() {
		return service_Invoice_Cards;
	}

	public void setService_Invoice_Cards(Set<ServiceInvoiceCard> service_Invoice_Cards) {
		this.service_Invoice_Cards = service_Invoice_Cards;
	}

}
