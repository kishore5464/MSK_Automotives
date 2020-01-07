package com.msk.automotive.service.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;

@Configuration
@PropertySource("classpath:/application_path.properties")
@RestController
@Path("/")
public class GenericController {

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@POST
	@Path("/forget-password")
	public Response forget_password(@FormParam("username") String username, @Context HttpServletRequest request) {
		String status = null;

		try {
			status = insert_Business_Interface.insertAccessCodeAndSend(username);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(status).build();
	}

	@POST
	@Path("/verify-access")
	public Response verify_access(@FormParam("user_name") String username, @FormParam("access_code") String access_code,
			@Context HttpServletRequest request) {
		String status = null;

		try {
			status = get_Business_Interface.getVerifyAccessCode(username, access_code);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(status).build();
	}

}
