package com.msk.automotive.business.implementations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.dao.repositories.Get_DAO_Interface;
import com.msk.automotive.dao.repositories.Update_DAO_Interface;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CardStatus;
import com.msk.automotive.service.entities.CardType;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.CustomerDetails;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.ServiceInvoiceCard;
import com.msk.automotive.service.entities.StockStatus;
import com.msk.automotive.service.pojo.ServiceCard_Pojo;
import com.msk.automotive.service.pojo.ServiceParts_Pojo;
import com.msk.automotive.utilities.Encrypt_Decrypt;

@Service
public class Update_Business_Impl implements Update_Business_Interface {

	@Autowired
	Update_DAO_Interface update_DAO_Interface;

	@Autowired
	Get_DAO_Interface get_DAO_Interface;

	@Override
	public String updateMSKOwnerPassword(String username, String password) {
		List<MSK_Owner> msk_Owner = get_DAO_Interface.getMSKOwnerDetail(username);

		String status = "not update";

		if (!msk_Owner.isEmpty()) {
			Encrypt_Decrypt encrypt_Decrypt = new Encrypt_Decrypt();
			msk_Owner.get(0).setPassword(encrypt_Decrypt.encrypt(password));

			update_DAO_Interface.updateMSKOwner(msk_Owner.get(0));
			status = "updated";
		}

		return status;
	}

	@Override
	public void updateSparePartsInStock(String spare_part_id, String quantity, String price_per_unit) {
		// TODO Auto-generated method stub
		List<Parts> parts = get_DAO_Interface.getSparePartsInStockById(spare_part_id);

		if (!parts.isEmpty()) {
			Car_Models car_Models = new Car_Models();
			car_Models.setId(parts.get(0).getCar_Models().getId());

			parts.get(0).setCar_Models(car_Models);
			parts.get(0).setQuantity(Integer.parseInt(quantity));
			parts.get(0).setAmount(Double.parseDouble(price_per_unit));
			parts.get(0).setParts_status(Stock_Status.INSTOCK);

			update_DAO_Interface.updateSparePartsInStock(parts.get(0));
		}
	}

	@Override
	public Service_Card_Pojo updateExistingServiceCardStatus(String service_type, String invoice_no,
			String process_type) {
		// TODO Auto-generated method stub
		Service_Card_Pojo service_Card_Pojo = new Service_Card_Pojo();

		List<Service_Invoice_Card> service_Invoice = get_DAO_Interface.getSericeInvoiceCardByServiceId(invoice_no);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (!service_Invoice.isEmpty()) {
			for (int i = 0; i < service_Invoice.size(); i++) {
				List<Customer_Details> customer_details = get_DAO_Interface
						.getCustomerDetailById(service_Invoice.get(i).getCustomer_Details().getId());

				if (service_Invoice.get(i).getCard_status().equals(Card_Status.OPEN)
						&& service_type.equalsIgnoreCase("open")) {
					if (process_type.equals("close") || process_type.equals("closed")) {
						service_Invoice.get(i).setCard_status(Card_Status.CLOSED);
						service_Invoice.get(i).setCard_type(Card_Type.INVOICE);

						update_DAO_Interface.updateExistingServiceCardStatus(service_Invoice.get(i));
					}
				} else if (service_Invoice.get(i).getCard_status().equals(Card_Status.CLOSED)
						&& service_type.equalsIgnoreCase("closed")) {
					if (process_type.equals("bill") || process_type.equals("billed")) {
						service_Invoice.get(i).setCard_status(Card_Status.BILLED);
						service_Invoice.get(i).setCard_type(Card_Type.INVOICE);

						update_DAO_Interface.updateExistingServiceCardStatus(service_Invoice.get(i));
					}
				}

				service_Card_Pojo.setInvoice_no(invoice_no);
				if (customer_details.get(0).getPolicy_expires_date() != null) {
					service_Card_Pojo.setPolicy_expires_date(
							dateFormat.format(customer_details.get(0).getPolicy_expires_date()));
				} else {
					service_Card_Pojo.setPolicy_expires_date("not available");
				}

				service_Card_Pojo.setCustomer_id(customer_details.get(0).getCustomer_id());
				if (customer_details.get(0).getLast_name() != null) {
					service_Card_Pojo.setName(
							customer_details.get(0).getFirst_name() + " " + customer_details.get(0).getLast_name());
				} else {
					service_Card_Pojo.setName(customer_details.get(0).getFirst_name());
				}
				service_Card_Pojo.setModel_id(Integer.toString(customer_details.get(0).getCar_Models().getId()));
				service_Card_Pojo.setMobile(customer_details.get(0).getMobile());
				service_Card_Pojo.setRegistration_no(customer_details.get(0).getRegistration_no());
				service_Card_Pojo.setGst_no(customer_details.get(0).getGst_no());
				if (customer_details.get(0).getEngine_no() != null) {
					service_Card_Pojo.setEngine_no(customer_details.get(0).getEngine_no());
				} else {
					service_Card_Pojo.setEngine_no("not available");
				}

				List<Customer_Contact_Details> customer_contact_details = get_DAO_Interface
						.getCustomerContactDetails(customer_details.get(0).getId());
				if (!customer_contact_details.isEmpty()) {

					if (customer_contact_details.get(0).getAddress_line_2() != null) {
						service_Card_Pojo.setAddress_line(customer_contact_details.get(0).getAddress_line_1() + ", "
								+ customer_contact_details.get(0).getAddress_line_2());
					} else {
						service_Card_Pojo.setAddress_line(customer_contact_details.get(0).getAddress_line_1());
					}

					service_Card_Pojo.setCity(get_DAO_Interface
							.getLocationByCityId(customer_contact_details.get(0).getLocation().getId()));
					service_Card_Pojo.setPincode(Integer.toString(customer_contact_details.get(0).getPincode()));
				}
			}
		}

		return service_Card_Pojo;
	}

	@Override
	public List<Service_Parts_Pojo> updateStockPartsAndStatus(String model_id, Service_Parts_Pojo service_Parts_Pojo) {
		// TODO Auto-generated method stub
		List<Parts> parts = get_DAO_Interface.getSparePartsAtParticularModel(model_id);
		//List<Service_Parts_Pojo> parts_list = new ArrayList<Service_Parts_Pojo>();

		if (!parts.isEmpty()) {
			for (int i = 0; i < parts.size(); i++) {
				if (parts.get(i).getPart().equals(service_Parts_Pojo.getPart())) {

					parts.get(i).setAmount(Double.parseDouble(service_Parts_Pojo.getAmount()));

					if (parts.get(i).getQuantity() > Integer.parseInt(service_Parts_Pojo.getQuantity())) {
						parts.get(i).setQuantity(
								parts.get(i).getQuantity() - Integer.parseInt(service_Parts_Pojo.getQuantity()));

						parts.get(i).setParts_status(Stock_Status.INSTOCK);

						update_DAO_Interface.updateSparePartsInStock(parts.get(i));
					} else if (parts.get(i).getQuantity() == Integer.parseInt(service_Parts_Pojo.getQuantity())) {
						parts.get(i).setQuantity(
								parts.get(i).getQuantity() - Integer.parseInt(service_Parts_Pojo.getQuantity()));

						parts.get(i).setParts_status(Stock_Status.OUTSTOCK);

						update_DAO_Interface.updateSparePartsInStock(parts.get(i));
					} else if (parts.get(i).getQuantity() < Integer.parseInt(service_Parts_Pojo.getQuantity())) {
//						parts.get(i).setQuantity(quantity);

						parts.get(i).setParts_status(Stock_Status.NOT_PURCHASED);

						update_DAO_Interface.updateSparePartsInStock(parts.get(i));
					}

				}
			}
		}

		return null;
	}

}
