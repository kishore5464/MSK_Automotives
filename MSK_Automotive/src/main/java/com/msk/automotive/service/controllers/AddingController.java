package com.msk.automotive.service.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;
import com.msk.automotive.service.pojo.Car_Brands_Pojo;
import com.msk.automotive.service.pojo.Car_Models_Pojo;
import com.msk.automotive.service.pojo.Service_Card_Pojo;
import com.msk.automotive.service.pojo.Service_Parts_Pojo;
import com.msk.automotive.service.pojo.Spare_Parts_Pojo;

import net.minidev.json.JSONObject;

//@Configuration
//@PropertySource("classpath:/application_path.properties")
//@RestController
//@Path("/")
public class AddingController {
//
//	// HERE I WROTE SERVLET FOR ADDING BRAND, MODEL, PARTS, CUSTOMER DETAILS
//	@Autowired
//	Get_Business_Interface get_Business_Interface;
//
//	@Autowired
//	Insert_Business_Interface insert_Business_Interface;
//
//	@Autowired
//	Update_Business_Interface update_Business_Interface;
//
//	@POST
//	@Path("/add-car-brand")
//	public Response add_car_brand(@FormParam("brand") String brand, @FormParam("logo") String logo,
//			@Context HttpServletRequest request) {
//		JSONObject mix = new JSONObject();
//		JSONObject data = new JSONObject();
//
//		ModelAndView view = null;
//
//		try {
//			insert_Business_Interface.insertCarBrand(brand, logo);
//
//			List<Car_Brands_Pojo> brands = get_Business_Interface.getAllBrands("service");
//
//			data.put("brands", brands);
//
//			mix.put("data", data);
//
//			view = new ModelAndView("/car_brands", mix);
//
//		} catch (Exception e) {
//			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
//		}
//
//		return Response.ok().entity(view).build();
//	}
//
//	@POST
//	@Path("/add-car-model")
//	public Response add_car_models(@FormParam("brand_id") String brand_id, @FormParam("model") String model,
//			@FormParam("image") String image, @Context HttpServletRequest request) {
//		JSONObject mix = new JSONObject();
//		JSONObject data = new JSONObject();
//
//		ModelAndView view = null;
//
//		try {
//			insert_Business_Interface.insertCarModel(brand_id, model, image);
//			List<Car_Models_Pojo> models = get_Business_Interface.getModels(brand_id, "service");
//
//			data.put("models", models);
//
//			mix.put("data", data);
//
//			view = new ModelAndView("/car_models", mix);
//		} catch (Exception e) {
//			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
//		}
//
//		return Response.ok().entity(view).build();
//	}
//
//	@POST
//	@Path("/add-customer-detail")
//	public Response add_customer_detail(@FormParam("model_id") String model_id,
//			@FormParam("first_name") String first_name, @FormParam("last_name") String last_name,
//			@FormParam("mobile") String mobile, @FormParam("email") String email, @FormParam("dob") String dob,
//			@FormParam("registration_no") String registration_no, @FormParam("gst_no") String gst_no,
//			@FormParam("customer_id") String customer_id, @FormParam("address_line_1") String address_line_1,
//			@FormParam("address_line_2") String address_line_2, @FormParam("location_id") String location_id,
//			@FormParam("pincode") String pincode, @Context HttpServletRequest request) {
//		JSONObject mix = new JSONObject();
//		JSONObject data = new JSONObject();
//		ModelAndView view = null;
//
//		try {
//			Service_Card_Pojo service_Card_Pojo = insert_Business_Interface.insertCustomerDetail(model_id, first_name,
//					last_name, mobile, email, dob, registration_no, gst_no, address_line_1, address_line_2, location_id,
//					pincode);
//			data.put("Service_card", service_Card_Pojo);
//			mix.put("data", data);
//
//			view = new ModelAndView("/service_card", mix);
//		} catch (Exception e) {
//			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
//		}
//
//		return Response.ok().entity(view).build();
//	}
//
//	@POST
//	@Path("/add-spare-part")
//	public Response add_spare_part(@FormParam("model_id") String model_id, @FormParam("part") String part,
//			@FormParam("quantity") String quantity, @FormParam("amount") String amount,
//			@Context HttpServletRequest request) {
//		JSONObject mix = new JSONObject();
//		JSONObject data = new JSONObject();
//
//		ModelAndView view = null;
//
//		try {
//			insert_Business_Interface.insertSparePart(model_id, part, quantity, amount);
//
//			List<Spare_Parts_Pojo> spare_Parts_Pojos = get_Business_Interface.getSparePartsInStock("INSTOCK");
//			data.put("spare_parts", spare_Parts_Pojos);
//			mix.put("data", data);
//
//			view = new ModelAndView("/spareparts", mix);
//		} catch (Exception e) {
//			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
//		}
//
//		return Response.ok().entity(view).build();
//	}
//
//	@POST
//	@Path("/add-service-card")
//	public Response add_service_card(@FormParam("customer_detail_id") String customer_detail_id,
//			@FormParam("service_type_id") String service_type_id,
//			@FormParam("service_adviser_id") String service_adviser_id, @FormParam("kilometer") String kilometer,
//			@FormParam("service_detail") String service_detail, @FormParam("tool_kit") String tool_kit,
//			@FormParam("spare_wheel") String spare_wheel, @FormParam("jack") String jack,
//			@FormParam("jack_handler") String jack_handler, @FormParam("car_perfume") String car_perfume,
//			@FormParam("clock") String clock, @FormParam("cd_player") String cd_player,
//			@FormParam("submit_type") String submit_type, @FormParam("service_expire_date") String service_expire_date,
//			@Context HttpServletRequest request) {
//
//		String status = null;
//
//		try {
//
//			ObjectMapper mapper = new ObjectMapper();
//
//			String[] service_detail_Array = service_detail.replace("[", "").replace("]", "").replace("},{", "},;{")
//					.split(";");
//
//			List<Service_Parts_Pojo> service_Parts_Pojos = new ArrayList<Service_Parts_Pojo>();
//
//			for (int i = 0; i < service_detail_Array.length; i++) {
//				String value = service_detail_Array[i];
//				Service_Parts_Pojo service_Parts_Pojo = mapper.readValue(value, Service_Parts_Pojo.class);
//
//				service_Parts_Pojos.add(service_Parts_Pojo);
//			}
//
//			status = "success";
//
//		} catch (Exception e) {
//			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
//		}
//
//		return Response.ok().entity(status).build();
//	}
//
}