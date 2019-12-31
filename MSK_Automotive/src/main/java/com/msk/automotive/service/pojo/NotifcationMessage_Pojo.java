package com.msk.automotive.service.pojo;

public class NotifcationMessage_Pojo {

	private String notification_id;
	private String message;

	public NotifcationMessage_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotifcationMessage_Pojo(String notification_id, String message) {
		super();
		this.notification_id = notification_id;
		this.message = message;
	}

	public String getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notifcation_Message_Pojo [notification_id=" + notification_id + ", message=" + message + "]";
	}

}
