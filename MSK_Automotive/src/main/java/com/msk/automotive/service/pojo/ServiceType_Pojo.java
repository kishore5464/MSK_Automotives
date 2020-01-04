package com.msk.automotive.service.pojo;

public class ServiceType_Pojo {

	private String id;
	private String serviceType;

	public ServiceType_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceType_Pojo(String id, String serviceType) {
		super();
		this.id = id;
		this.serviceType = serviceType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}