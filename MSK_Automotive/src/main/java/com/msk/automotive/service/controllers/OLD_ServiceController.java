package com.msk.automotive.service.controllers;

import java.io.IOException;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.exception.CustomGenericException;
import com.msk.automotive.service.pojo.JobCardStatus_Pojo;
import com.msk.automotive.service.pojo.ServiceAdvicer_Pojo;
import com.msk.automotive.service.pojo.ServiceCard_Pojo;
import com.msk.automotive.service.pojo.ServiceParts_Pojo;
import com.msk.automotive.service.pojo.ServiceType_Pojo;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class OLD_ServiceController {

	@Autowired
	private Get_Business_Interface get_Business_Interface;

	@Autowired
	private Insert_Business_Interface insert_Business_Interface;

	@Autowired
	private Update_Business_Interface update_Business_Interface;

	@GET
	@Path("/service-type")
	public Response service_type() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			List<ServiceType_Pojo> service_Type_Pojos = get_Business_Interface.getServiceType();

			data.put("service_type", service_Type_Pojos);
			data.put("service_type_count", service_Type_Pojos.size());

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	@GET
	@Path("/service-advicer")
	public Response service_advicer() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			List<ServiceAdvicer_Pojo> service_advicer = get_Business_Interface.getServiceAdvicers();

			data.put("service_advicer", service_advicer);
			data.put("service_advicer_count", service_advicer.size());
			mix.put("data", data);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(mix.toString()).build();
	}

	@POST
	@Path("/service-card")
	public Response service_card_detail(@FormParam("customer_id") String customer_id,
			@Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		ModelAndView view = null;

		// try {
		System.out.println(customer_id);
		ServiceCard_Pojo service_Card_Pojo = get_Business_Interface.getCustomerDetail(customer_id);

		data.put("customer_detail", service_Card_Pojo);
		mix.put("data", data);

		view = new ModelAndView("/service_card", mix);
		// } catch (Exception e) {
		// throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		// }

		return Response.ok().entity(view).build();
	}

	@POST
	@Path("/service-invoice")
	public Response service_inoice(@FormParam("invoice_status") String invoice_status,
			@Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();
		ModelAndView view = null;

		try {
			List<JobCardStatus_Pojo> job_Card_Status_Pojos = get_Business_Interface.getJobCardStatus(invoice_status);
			data.put("card_details", job_Card_Status_Pojos);

			mix.put("data", data);
			view = new ModelAndView("/service_invoice", mix);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	@GET
	@Path("/service-card-detail")
	public void service_card_detail() throws IOException {

		JSONObject data = new JSONObject();
		JSONObject mix = new JSONObject();

		String model_id = "10";
		String parts = "[{\"part_id\": \"1\",\"part\": \"Vyper\",\"amount\": \"560\",\"quantity\": \"6\"}]";

		try {
			ObjectMapper mapper = new ObjectMapper();
			String[] filterArray = parts.trim().replace("[", "").replace("]", "").replace("}, {", "};{").split(";");

			ServiceParts_Pojo service_Parts_Pojo = new ServiceParts_Pojo();

			for (int i = 0; i < filterArray.length; i++) {
				String value = filterArray[i];
				service_Parts_Pojo = mapper.readValue(value, ServiceParts_Pojo.class);
			}

			List<ServiceParts_Pojo> existing_stock = update_Business_Interface.updateStockPartsAndStatus(model_id,
					service_Parts_Pojo);

			if (!existing_stock.isEmpty()) {
				data.put("parts", existing_stock);
			} else {
				data.put("parts", "empty");
			}

			data.put("parts_size", existing_stock.size());

			mix.put("data", data);

			// data.put("filter", filterResult);
			//
			// if (!filterResult.isEmpty()) {
			// data.put("filter_size", filterResult.get(0).getFilter_size());
			//
			// }

			mix.put("data", data);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}
		// return Response.ok().entity(mix.toString()).build();
	}

	@POST
	@Path("/service-card-status-change")
	public Response service_card_status_change(@FormParam("service_type") String service_type,
			@FormParam("invoice_no") String invoice_no, @FormParam("process_type") String process_type,
			@Context HttpServletRequest request) throws IOException {

		JSONObject data = new JSONObject();
		JSONObject mix = new JSONObject();

		ModelAndView view = null;

		// OPEN, CLOSE, BILLED
		// EXISTING SERVICE CARD STATUS
		// String service_type = "closed";

		// INVOICE NUMBER
		// String invoice_no = "MSKS004";

		// PROCESS TYPE
		// CHECK SERVICE_TYPE AND DECIDE
		// 1. OPEN => VIEW | CLOSE;
		// 2. CLOSE => VIEW | BILLED;
		// 3. BILLED => VIEW
		// String process_type = "billed";

		try {
			ServiceCard_Pojo service_Card_Pojo = update_Business_Interface.updateExistingServiceCardStatus(service_type,
					invoice_no, process_type);

			data.put("filter", service_Card_Pojo);

			List<JobCardStatus_Pojo> job_Card_Status_Pojos = get_Business_Interface.getJobCardStatus(service_type);
			data.put("card_details", job_Card_Status_Pojos);

			mix.put("data", data);

			view = new ModelAndView("/service_invoice", mix);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

}