package com.msk.automotive.business.implementations;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Update_Business_Interface;
import com.msk.automotive.dao.repositories.CarBrand_Repository;
import com.msk.automotive.dao.repositories.CarModel_Repository;
import com.msk.automotive.dao.repositories.CustomerContactDetails_Repository;
import com.msk.automotive.dao.repositories.CustomerDetails_Repository;
import com.msk.automotive.dao.repositories.Location_Repository;
import com.msk.automotive.dao.repositories.MSKOwners_Repository;
import com.msk.automotive.dao.repositories.Parts_Repository;
import com.msk.automotive.dao.repositories.ServiceInvoiceCard_Repository;
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
	private CarBrand_Repository carBrand_Repository;

	@Autowired
	private CarModel_Repository carModel_Repository;

	@Autowired
	private CustomerDetails_Repository customerDetails_Repository;

	@Autowired
	private CustomerContactDetails_Repository customerContactDetails_Repository;

	@Autowired
	private Location_Repository location_Repository;

	@Autowired
	private MSKOwners_Repository mskOwners_Repository;

	@Autowired
	private Parts_Repository parts_Repository;

	@Autowired
	private ServiceInvoiceCard_Repository serviceInvoiceCard_Repository;

	@Override
	public String updateMSKOwnerPassword(String username, String password) {
		List<MSKOwner> msk_Owner = mskOwners_Repository.findByEmail(username);

		String status = "not update";

		if (!msk_Owner.isEmpty()) {
			Encrypt_Decrypt encrypt_Decrypt = new Encrypt_Decrypt();
			msk_Owner.get(0).setPassword(encrypt_Decrypt.encrypt(password));

			mskOwners_Repository.save(msk_Owner.get(0));
			status = "updated";
		}

		return status;
	}

	@Override
	public void updateSparePartsInStock(String spare_part_id, String quantity, String price_per_unit) {
		List<Parts> parts = parts_Repository.findByPartsStatus(spare_part_id);

		if (!parts.isEmpty()) {
			CarModels car_Models = new CarModels();
			car_Models.setId(parts.get(0).getCarModels().getId());

			parts.get(0).setCarModels(car_Models);
			parts.get(0).setQuantity(Integer.parseInt(quantity));
			parts.get(0).setAmount(Double.parseDouble(price_per_unit));
			parts.get(0).setPartsStatus(StockStatus.INSTOCK);

			parts_Repository.save(parts.get(0));
		}
	}

	@Override
	public ServiceCard_Pojo updateExistingServiceCardStatus(String service_type, String invoice_no,
			String process_type) {
		ServiceCard_Pojo service_Card_Pojo = new ServiceCard_Pojo();

		List<ServiceInvoiceCard> service_Invoice = serviceInvoiceCard_Repository.findByServiceId(invoice_no);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (!service_Invoice.isEmpty()) {
			for (int i = 0; i < service_Invoice.size(); i++) {
				Optional<CustomerDetails> customer_details = customerDetails_Repository
						.findById(service_Invoice.get(i).getCustomerDetails().getId());

				if (service_Invoice.get(i).getCardStatus().equals(CardStatus.OPEN)
						&& service_type.equalsIgnoreCase("open")) {
					if (process_type.equals("close") || process_type.equals("closed")) {
						service_Invoice.get(i).setCardStatus(CardStatus.CLOSED);
						service_Invoice.get(i).setCardType(CardType.INVOICE);

						serviceInvoiceCard_Repository.save(service_Invoice.get(i));
					}
				} else if (service_Invoice.get(i).getCardStatus().equals(CardStatus.CLOSED)
						&& service_type.equalsIgnoreCase("closed")) {
					if (process_type.equals("bill") || process_type.equals("billed")) {
						service_Invoice.get(i).setCardStatus(CardStatus.BILLED);
						service_Invoice.get(i).setCardType(CardType.INVOICE);

						serviceInvoiceCard_Repository.save(service_Invoice.get(i));
					}
				}

				service_Card_Pojo.setInvoice_no(invoice_no);
				if (customer_details.get().getPolicyExpiresDate() != null) {
					service_Card_Pojo
							.setPolicy_expires_date(dateFormat.format(customer_details.get().getPolicyExpiresDate()));
				} else {
					service_Card_Pojo.setPolicy_expires_date("not available");
				}

				service_Card_Pojo.setCustomer_id(customer_details.get().getCustomerId());
				if (customer_details.get().getLastName() != null) {
					service_Card_Pojo.setName(
							customer_details.get().getFirstName() + " " + customer_details.get().getLastName());
				} else {
					service_Card_Pojo.setName(customer_details.get().getFirstName());
				}
				service_Card_Pojo.setModel_id(Integer.toString(customer_details.get().getCarModels().getId()));
				service_Card_Pojo.setMobile(customer_details.get().getMobile());
				service_Card_Pojo.setRegistration_no(customer_details.get().getRegistrationNo());
				service_Card_Pojo.setGst_no(customer_details.get().getGstNo());
				if (customer_details.get().getEngineNo() != null) {
					service_Card_Pojo.setEngine_no(customer_details.get().getEngineNo());
				} else {
					service_Card_Pojo.setEngine_no("not available");
				}

				Optional<CustomerContactDetails> customer_contact_details = customerContactDetails_Repository
						.findById(customer_details.get().getId());
				if (!customer_contact_details.isPresent()) {

					if (customer_contact_details.get().getAddressLine2() != null) {
						service_Card_Pojo.setAddress_line(customer_contact_details.get().getAddressLine1() + ", "
								+ customer_contact_details.get().getAddressLine2());
					} else {
						service_Card_Pojo.setAddress_line(customer_contact_details.get().getAddressLine1());
					}

					service_Card_Pojo.setCity(location_Repository
							.findById(customer_contact_details.get().getLocation().getId()).get().getCity());
					service_Card_Pojo.setPincode(Integer.toString(customer_contact_details.get().getPincode()));
				}
			}
		}

		return service_Card_Pojo;
	}

	@Override
	public List<ServiceParts_Pojo> updateStockPartsAndStatus(String model_id, ServiceParts_Pojo service_Parts_Pojo) {
		List<Parts> parts = parts_Repository.findByCarModels(Integer.parseInt(model_id));

		if (!parts.isEmpty()) {
			for (int i = 0; i < parts.size(); i++) {
				if (parts.get(i).getPart().equals(service_Parts_Pojo.getPart())) {

					parts.get(i).setAmount(Double.parseDouble(service_Parts_Pojo.getAmount()));

					if (parts.get(i).getQuantity() > Integer.parseInt(service_Parts_Pojo.getQuantity())) {
						parts.get(i).setQuantity(
								parts.get(i).getQuantity() - Integer.parseInt(service_Parts_Pojo.getQuantity()));

						parts.get(i).setPartsStatus(StockStatus.INSTOCK);

					} else if (parts.get(i).getQuantity() == Integer.parseInt(service_Parts_Pojo.getQuantity())) {
						parts.get(i).setQuantity(
								parts.get(i).getQuantity() - Integer.parseInt(service_Parts_Pojo.getQuantity()));

						parts.get(i).setPartsStatus(StockStatus.OUTSTOCK);

					} else if (parts.get(i).getQuantity() < Integer.parseInt(service_Parts_Pojo.getQuantity())) {
//						parts.get(i).setQuantity(quantity);

						parts.get(i).setPartsStatus(StockStatus.NOT_PURCHASED);

					}

					parts_Repository.save(parts.get(i));

				}
			}
		}

		return null;
	}

}
