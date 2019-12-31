package com.msk.automotive.service.pojo;

public class ServiceType_Pojo {

	private String id;
	private String service_type;

	public ServiceType_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceType_Pojo(String id, String service_type) {
		super();
		this.id = id;
		this.service_type = service_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

}