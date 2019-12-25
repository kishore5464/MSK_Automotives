package com.msk.automotive.service.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;
import com.msk.automotive.service.pojo.Spare_Parts_Pojo;

import net.minidev.json.JSONObject;

//import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class UpdateController {

	// HERE I WROTE SERVLET FOR UPDATE BRAND, MODEL, PARTS, CUSTOMER DETAILS

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	@POST
	@Path("/update-spare-part")
	public Response update_parts(@FormParam("spare_part_id") String spare_part_id,
			@FormParam("quantity") String quantity, @FormParam("amount") String amount,
			@Context HttpServletRequest request) {

		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;

		try {
			System.out.println(spare_part_id);
			System.out.println(quantity);
			System.out.println(amount);

			update_Business_Interface.updateSparePartsInStock(spare_part_id, quantity, amount);

			// System.out.println("STOCK STATUS --> " + stock_status);
			List<Spare_Parts_Pojo> spare_Parts_Pojos = get_Business_Interface.getSparePartsInStock("INSTOCK");

			// System.out.println("SPARE PARTS OF " + stock_status.toUpperCase()
			// + " --> " + spare_Parts_Pojos);
			data.put("spare_parts", spare_Parts_Pojos);
			mix.put("data", data);

			view = new ModelAndView("/spareparts", mix);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}
		return Response.ok().entity(view).build();

	}

	/*
	 * @PUT
	 * 
	 * @Path("/update-customer-detail") public Response
	 * add_customer_detail(@FormParam("model_id") String model_id,
	 * 
	 * @FormParam("first_name") String first_name, @FormParam("last_name") String
	 * last_name,
	 * 
	 * @FormParam("mobile") String mobile, @FormParam("email") String
	 * email, @FormParam("dob") String dob,
	 * 
	 * @FormParam("registration_no") String registration_no, @FormParam("gst_no")
	 * String gst_no,
	 * 
	 * @FormParam("customer_id") String customer_id, @FormParam("address_line_1")
	 * String address_line_1,
	 * 
	 * @FormParam("address_line_2") String address_line_2, @FormParam("location_id")
	 * String location_id,
	 * 
	 * @FormParam("pincode") String pincode, @Context HttpServletRequest request) {
	 * JSONObject mix = new JSONObject(); JSONObject data = new JSONObject();
	 * 
	 * try { // data } catch (Exception e) { throw new CustomGenericException("" +
	 * e.hashCode(), e.getMessage()); }
	 * 
	 * return Response.ok().entity(mix.toString()).build(); }
	 * 
	 * @PUT
	 * 
	 * @Path("/update-password") public Response
	 * update_password(@FormParam("username") String
	 * username, @FormParam("password") String password,
	 * 
	 * @Context HttpServletRequest request) { String status = null;
	 * 
	 * try { update_Business_Interface.updateMSKOwnerPassword(username, password);
	 * status = "success"; } catch (Exception e) { throw new
	 * CustomGenericException("" + e.hashCode(), e.getMessage()); }
	 * 
	 * return Response.ok().entity(status).build(); }
	 * 
	 * @PUT
	 * 
	 * @Path("/update-invoice") public Response
	 * update_invoice(@FormParam("username") String username, @FormParam("password")
	 * String password,
	 * 
	 * @Context HttpServletRequest request) { String status = null;
	 * 
	 * try { update_Business_Interface.updateMSKOwnerPassword(username, password);
	 * status = "success"; } catch (Exception e) { throw new
	 * CustomGenericException("" + e.hashCode(), e.getMessage()); }
	 * 
	 * return Response.ok().entity(status).build(); }
	 */

}
