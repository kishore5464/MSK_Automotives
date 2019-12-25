package com.msk.automotive.service.pojo;

public class Service_Type_Pojo {

	private String id;
	private String service_type;

	public Service_Type_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service_Type_Pojo(String id, String service_type) {
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