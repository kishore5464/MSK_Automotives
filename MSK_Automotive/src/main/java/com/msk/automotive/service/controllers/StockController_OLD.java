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
import com.msk.automotive.service.pojo.CarBrands_Pojo;
import com.msk.automotive.service.pojo.CarModels_Pojo;
import com.msk.automotive.service.pojo.ServiceParts_Pojo;
import com.msk.automotive.service.pojo.SpareParts_Pojo;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class StockController_OLD {

	// HERE I WROTE SERVLET FOR ADDING BRAND, MODEL, PARTS, CUSTOMER DETAILS
	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	// CHECK BRANDS FOR ADD SPARE PARTS
	@POST
	@Path("/check-brand-stock")
	public Response parts_car_brand() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			List<CarBrands_Pojo> brands = get_Business_Interface.getAllBrands("parts");

			data.put("brands", brands);

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	// TO ADD NEW PART IN PARTICULAR MODEL
	// FROM PARTS CAR BRAND
	@POST
	@Path("/check-model-stock")
	public Response parts_car_models(@FormParam("brand_id") String brand_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			List<CarModels_Pojo> models = get_Business_Interface.getModels(brand_id, "parts");

			data.put("models", models);

			if (!models.isEmpty()) {
				data.put("brand_id", models.get(0).getBrand_id());
			}

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	@POST
	@Path("/check-part-stock")
	public Response exists_model_parts(@FormParam("model_id") String model_id, @Context HttpServletRequest request) {

		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			List<String> parts = get_Business_Interface.getSparePartsAtParticularModel(model_id);

			if (!parts.isEmpty()) {
				data.put("parts", parts);
			} else {
				data.put("parts", "empty");
			}

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	// TO ADD NEW PART IN PARTICULAR MODEL AND PART
	// FROM PARTS CAR MODEL
	@POST
	@Path("/exists-parts")
	public Response exists_parts(@FormParam("model_id") String model_id, @FormParam("part") String part,
			@Context HttpServletRequest request) {

		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			List<SpareParts_Pojo> spare_Parts_Pojos = get_Business_Interface.getSparePartsInStock("INSTOCK");

			data.put("in_stock_parts", spare_Parts_Pojos);

			SpareParts_Pojo spare_Parts_Pojo = get_Business_Interface.getSparePartsAtParticularModelParts(model_id,
					part);

			if (!spare_Parts_Pojo.getId().equals("0")) {
				data.put("spare_parts", spare_Parts_Pojo);
			} else {
				data.put("spare_parts", "empty");
			}

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	@POST
	@Path("/spare-parts")
	public Response spare_partsGet(@FormParam("stock_status") String stock_status,
			@Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;

		try {
			List<SpareParts_Pojo> spare_Parts_Pojos = get_Business_Interface.getSparePartsInStock(stock_status);

			data.put("spare_parts", spare_Parts_Pojos);
			data.put("stock_status", stock_status);

			mix.put("data", data);

			view = new ModelAndView("/spareparts", mix);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	// IN SERVICE WE USED TO VIEW PARTS
	@POST
	@Path("/part-stock")
	public Response part_stock(@FormParam("model_id") String model_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			List<ServiceParts_Pojo> parts = get_Business_Interface.getSparePartsAtParticularModelPojo(model_id);

			if (!parts.isEmpty()) {
				data.put("parts", parts);
			} else {
				data.put("parts", "empty");
			}
			data.put("parts_size", parts.size());
			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	// IN SERVICE WE USED TO VIEW PARTS AND ITS AMOUNT
	@POST
	@Path("/part-stock-amt")
	public Response part_stock_amt(@FormParam("part_id") String part_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			List<ServiceParts_Pojo> parts = get_Business_Interface.getSparePartsAtParticularAmt(part_id);

			if (!parts.isEmpty()) {
				data.put("parts", parts);
			} else {
				data.put("parts", "empty");
			}
			data.put("parts_size", parts.size());
			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}
}