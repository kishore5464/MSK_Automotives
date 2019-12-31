package com.msk.automotive.service.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;
import com.msk.automotive.service.pojo.NotifcationMessage_Pojo;
import com.msk.automotive.service.pojo.Notifcation_Pojo;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class NotificationController {

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	@GET
	@Path("/notification")
	public Response notification() {
		JSONObject data = new JSONObject();
		JSONObject mix = new JSONObject();

		try {
			List<NotifcationMessage_Pojo> notifcation_Message_Pojos = get_Business_Interface
					.getServiceNotificationMessage();
			System.out.println(notifcation_Message_Pojos.toString());
			System.out.println(notifcation_Message_Pojos.size());
			data.put("notification", notifcation_Message_Pojos);
			data.put("notification_size", notifcation_Message_Pojos.size());

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	@GET
	@Path("/notification_update")
	public Response notification_update(/* @FormParam("notification_id") String notification_id, */
			@Context HttpServletRequest request) {
		JSONObject data = new JSONObject();
		JSONObject mix = new JSONObject();

		try {
			List<Notifcation_Pojo> notifications = get_Business_Interface.getCustomerServiceNotification("0");
			// List<Notifcation_Pojo> notifications =
			// get_Business_Interface.getServiceNotification();
			System.out.println(notifications.toString());
			System.out.println(notifications.size());
			data.put("notification", notifications);

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

}
