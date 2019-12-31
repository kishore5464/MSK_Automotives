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
@Table(name = "mskOwner")
public class MSKOwner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String accessCode;
	private Date createdDate;

	private Set<ServiceAdvisor> serviceAdvisers = new HashSet<ServiceAdvisor>();

	public MSKOwner() {
		super();
	}

	public MSKOwner(Integer id, String name, String email, String mobile, String password, String accessCode,
			Date createdDate, Set<ServiceAdvisor> serviceAdvisers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.accessCode = accessCode;
		this.createdDate = createdDate;
		this.serviceAdvisers = serviceAdvisers;
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "accessCode")
	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mskOwner", cascade = CascadeType.ALL)
	public Set<ServiceAdvisor> getServiceAdvisers() {
		return serviceAdvisers;
	}

	public void setServiceAdvisers(Set<ServiceAdvisor> serviceAdvisers) {
		this.serviceAdvisers = serviceAdvisers;
	}

}
