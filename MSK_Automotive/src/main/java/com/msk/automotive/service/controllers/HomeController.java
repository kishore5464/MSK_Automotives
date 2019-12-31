package com.msk.automotive.service.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@RestController
public class HomeController {

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	@Autowired
	Environment env;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		return new ModelAndView("/index");
	}

	@GET
	@Path("/login")
	public ModelAndView login() {
		return new ModelAndView("/login");
	}

	@GET
	@Path("/customer_details")
	public ModelAndView customer_details() {
		return new ModelAndView("/customer_details");
	}

	@POST
	@Path("/login")
	public Response login_cred(@FormParam("username") String username, @FormParam("password") String password,
			@Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();

		ModelAndView view = null;
		String status = null;

		try {
			String msk_Owner = get_Business_Interface.getMSKOwnerDetail(username, password);

			if (msk_Owner.equals("success")) {
				status = "success";
				mix.put("status", status);
				view = new ModelAndView("/dashboard.jsp", mix);
			} else {
				status = "failure";
				mix.put("status", status);

				view = new ModelAndView("/login.jsp", mix);
			}
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

}