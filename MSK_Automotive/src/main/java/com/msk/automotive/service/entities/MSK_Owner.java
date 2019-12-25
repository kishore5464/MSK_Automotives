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
@Table(name = "msk_owner")
public class MSK_Owner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String access_code;
	private Date created_date;

	private Set<Service_Advisor> service_Advisers = new HashSet<Service_Advisor>();

	public MSK_Owner() {
		super();
	}

	public MSK_Owner(Integer id, String name, String email, String mobile, String password, String access_code,
			Date created_date, Set<Service_Advisor> service_Advisers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.access_code = access_code;
		this.created_date = created_date;
		this.setService_Advisers(service_Advisers);
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

	@Column(name = "access_code")
	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "msk_Owner")
	public Set<Service_Advisor> getService_Advisers() {
		return service_Advisers;
	}

	public void setService_Advisers(Set<Service_Advisor> service_Advisers) {
		this.service_Advisers = service_Advisers;
	}

}
