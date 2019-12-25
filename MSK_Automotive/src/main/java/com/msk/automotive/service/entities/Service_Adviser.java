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
@Table(name = "service_adviser")
public class Service_Adviser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private MSK_Owner msk_Owner;
	private String name;
	private String mobile;
	private Date created_date;

	private Set<Service_Invoice_Card> service_Invoice_Cards = new HashSet<Service_Invoice_Card>();

	public Service_Adviser() {
		super();
	}

	public Service_Adviser(Integer id, MSK_Owner msk_Owner, String name, String mobile, Date created_date,
			Set<Service_Invoice_Card> service_Invoice_Cards) {
		super();
		this.id = id;
		this.msk_Owner = msk_Owner;
		this.name = name;
		this.mobile = mobile;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "msk_owner_id")
	public MSK_Owner getMsk_Owner() {
		return msk_Owner;
	}

	public void setMsk_Owner(MSK_Owner msk_Owner) {
		this.msk_Owner = msk_Owner;
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
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "service_Adviser")
	public Set<Service_Invoice_Card> getService_Invoice_Cards() {
		return service_Invoice_Cards;
	}

	public void setService_Invoice_Cards(Set<Service_Invoice_Card> service_Invoice_Cards) {
		this.service_Invoice_Cards = service_Invoice_Cards;
	}

}
