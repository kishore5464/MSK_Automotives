package com.msk.automotive.service.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;
import com.msk.automotive.service.pojo.CarBrands_Pojo;
import com.msk.automotive.service.pojo.CarModels_Pojo;
import com.msk.automotive.service.pojo.CustomerDetails_Pojo;
import com.msk.automotive.service.pojo.Location_Pojo;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@RestController
@Path("/")
public class OLD_ListsController {

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	@POST
	@Path("/upload-model")
	public void upload_model(@FormParam("brand_id") String brand_id, @FormParam("model_id") String model_id,
			@FormParam("image") String image, @Context HttpServletRequest request) {
		try {
			insert_Business_Interface.insertOrUpdateModelLogo(model_id, image);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

	}

	// CAR BRAND FROM SERVICE
	@GET
	@Path("/car-brand")
	public Response car_brand() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;
		try {
			List<CarBrands_Pojo> brands = get_Business_Interface.getAllBrands("service");

			data.put("brands", brands);

			mix.put("data", data);

			view = new ModelAndView("/car_brands", mix);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	// CAR BRAND AND ITS MODEL FROM SERVICE
	@POST
	@Path("/{brand}/car-models")
	public Response car_models(@FormParam("brand_id") String brand_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;
		try {
			List<CarModels_Pojo> models = get_Business_Interface.getModels(brand_id, "service");

			data.put("models", models);

			if (!models.isEmpty()) {
				data.put("brand_id", models.get(0).getBrand_id());
			}

			mix.put("data", data);

			view = new ModelAndView("/car_models", mix);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	@POST
	@Path("/customer-detail")
	public Response customer_detail(@FormParam("modal_id") String model_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;
		// try {
		System.out.println(model_id);
		List<CustomerDetails_Pojo> existing_customer = get_Business_Interface
				.getExistingCustomerModelDetails(model_id);

		data.put("customer", existing_customer);
		mix.put("data", data);

		view = new ModelAndView("/customer_details", mix);
		// } catch (Exception e) {
		// throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		// }

		return Response.ok().entity(view).build();
	}

	@GET
	@Path("/location")
	public Response location() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			List<Location_Pojo> location_Pojos = get_Business_Interface.getLocation();
			data.put("location", location_Pojos);
			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

}
