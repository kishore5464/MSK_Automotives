package com.msk.automotive.business.implementations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.dao.repositories.CarBrand_Repository;
import com.msk.automotive.dao.repositories.CarModel_Repository;
import com.msk.automotive.dao.repositories.CustomerContactDetails_Repository;
import com.msk.automotive.dao.repositories.CustomerDetails_Repository;
import com.msk.automotive.dao.repositories.Location_Repository;
import com.msk.automotive.dao.repositories.MSKOwners_Repository;
import com.msk.automotive.dao.repositories.Notification_Repository;
import com.msk.automotive.dao.repositories.PartsStockMaintain_Repository;
import com.msk.automotive.dao.repositories.Parts_Repository;
import com.msk.automotive.dao.repositories.ServiceAdvisor_Repository;
import com.msk.automotive.dao.repositories.ServiceInvoiceCard_Repository;
import com.msk.automotive.dao.repositories.ServiceType_Repository;
import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.CustomerDetails;
import com.msk.automotive.service.entities.Location;
import com.msk.automotive.service.entities.ServiceInvoiceCard;
import com.msk.automotive.service.pojo.ServiceCard_Pojo;

@Service
public class Insert_Business_Impl implements Insert_Business_Interface {

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
	private Notification_Repository notification_Repository;

	@Autowired
	private Parts_Repository parts_Repository;

	@Autowired
	private PartsStockMaintain_Repository partsStockMaintain_Repository;

	@Autowired
	private ServiceAdvisor_Repository serviceAdvisor_Repository;

	@Autowired
	private ServiceInvoiceCard_Repository serviceInvoiceCard_Repository;

	@Autowired
	private ServiceType_Repository serviceType_Repository;

	@Override
	public void insertCarBrand(String brand, String logo) {
		List<CarBrands> brands = carBrand_Repository.findByBrand(brand);

		if (brands.isEmpty()) {
			CarBrands car_Brands = new CarBrands();
			car_Brands.setBrand(brand);
			car_Brands.setLogo(logo);

			carBrand_Repository.save(car_Brands);
		}
	}

	@Override
	public void insertCarModel(String brand_id, String model, String image) {
		Optional<CarModels> models = carModel_Repository.findById(Integer.parseInt(brand_id));

		if (models.isPresent() && models.get().getModel().equals(models)) {
			CarBrands car_Brands = new CarBrands();
			car_Brands.setId(Integer.parseInt(brand_id));

			CarModels car_Models = new CarModels();
			car_Models.setCarBrands(car_Brands);
			car_Models.setModel(model);
			car_Models.setImage(image);

			carModel_Repository.save(car_Models);
		}
	}

	@Override
	public ServiceCard_Pojo insertCustomerDetail(String model_id, String first_name, String last_name, String mobile,
			String email, String dob, String registration_no, String gst_no, String address_line_1,
			String address_line_2, String location_id, String pincode) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ServiceCard_Pojo service_Card_Pojo = new ServiceCard_Pojo();

		List<CustomerDetails> customer_Details_List = customerDetails_Repository.findByRegistrationNo(registration_no);

		if (customer_Details_List.isEmpty()) {
			CustomerDetails customer_Details = new CustomerDetails();

			CarModels car_Models = new CarModels();
			car_Models.setId(Integer.parseInt(model_id));

			customer_Details.setCarModels(car_Models);

			List<CustomerDetails> customer = customerDetails_Repository.findAll();

			if (!customer.isEmpty()) {
				if (customer.get(customer.size() - 1).getId() <= 9) {
					customer_Details.setCustomerId("MSKC00" + customer.get(customer.size() - 1).getId());
				} else if (customer.get(customer.size() - 1).getId() >= 10
						&& customer.get(customer.size() - 1).getId() <= 99) {
					customer_Details.setCustomerId("MSKC0" + customer.get(customer.size() - 1).getId());
				} else if (customer.get(customer.size() - 1).getId() >= 100
						&& customer.get(customer.size() - 1).getId() <= 999) {
					customer_Details.setCustomerId("MSKC" + customer.get(customer.size() - 1).getId());
				}
			} else {
				customer_Details.setCustomerId("MSKC001");
			}

			customer_Details.setFirstName(first_name);
			customer_Details.setLastName(last_name);
			customer_Details.setMobile(mobile);
			customer_Details.setEmail(email);

			try {
				customer_Details.setDob(dateFormat.parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			customer_Details.setRegistrationNo(registration_no);
			customer_Details.setGstNo(gst_no);

			customerDetails_Repository.save(customer_Details);

			CustomerContactDetails customer_Contact_Details = new CustomerContactDetails();

			Location location = new Location();
			location.setId(Integer.parseInt(location_id));
			customer_Contact_Details.setLocation(location);

			customer_Contact_Details.setAddressLine1(address_line_1);
			customer_Contact_Details.setAddressLine2(address_line_2);
			customer_Contact_Details.setPincode(Integer.parseInt(pincode));

			customerContactDetails_Repository.save(customer_Contact_Details);

			if (address_line_2 != null) {
				service_Card_Pojo.setAddress_line(address_line_1 + ", " + address_line_2);
			} else {
				service_Card_Pojo.setAddress_line(address_line_1);
			}

			service_Card_Pojo.setCity(location_Repository.findById(Integer.parseInt(location_id)).get().getCity());
			service_Card_Pojo.setName(first_name + " " + last_name);
			service_Card_Pojo.setGst_no(gst_no);

			List<ServiceInvoiceCard> service_Invoice_Cards = serviceInvoiceCard_Repository.findAll();

			if (!service_Invoice_Cards.isEmpty()) {
				if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 9) {
					service_Card_Pojo.setInvoice_no(
							"MSKS00" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
				} else if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() >= 10
						&& service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 99) {
					service_Card_Pojo.setInvoice_no(
							"MSKS0" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
				} else if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() >= 100
						&& service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 999) {
					service_Card_Pojo.setInvoice_no(
							"MSKS" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
				}
			} else {
				service_Card_Pojo.setInvoice_no("MSKS001");
			}

			service_Card_Pojo.setMobile(mobile);
			service_Card_Pojo.setPincode(pincode);
			service_Card_Pojo.setRegistration_no(registration_no);
		}

		return service_Card_Pojo;
	}

//	@Autowired
//	MailSenderService mailSenderService;

//	@Override
//	public void insertOrUpdateBrandLogo(String brand_id, String logo) {
//		// TODO Auto-generated method stub
//		List<CarBrands> brand = get_DAO_Interface.getBrandById(Integer.parseInt(brand_id));
//
//		if (!brand.isEmpty()) {
//			brand.get(0).setLogo(logo);
//
//			update_DAO_Interface.updateBrandDetail(brand.get(0));
//		}
//	}
//
//	@Override
//	public void insertOrUpdateModelLogo(String model_id, String logo) {
//		// TODO Auto-generated method stub
//		List<Car_Models> model = get_DAO_Interface.getModelById(Integer.parseInt(model_id));
//
//		if (!model.isEmpty()) {
//			model.get(0).setImage(logo);
//
//			update_DAO_Interface.updateModelDetail(model.get(0));
//		}
//	}
//
//	@Override
//	public void insertSparePart(String model_id, String part, String quantity, String amount) {
//		// TODO Auto-generated method stub
//		List<Parts> parts_List = get_DAO_Interface.getSparePartsAtParticularModelParts(Integer.parseInt(model_id),
//				part);
//		if (!parts_List.isEmpty()) {
//			Car_Models car_Models = new Car_Models();
//			car_Models.setId(parts_List.get(0).getCar_Models().getId());
//
//			parts_List.get(0).setCar_Models(car_Models);
//			parts_List.get(0).setPart(part);
//			parts_List.get(0).setQuantity(Integer.parseInt(quantity));
//			parts_List.get(0).setParts_status(Stock_Status.INSTOCK);
//			parts_List.get(0).setAmount(Double.parseDouble(amount));
//
//			update_DAO_Interface.updateSparePartsInStock(parts_List.get(0));
//		} else {
//			Parts parts = new Parts();
//
//			Car_Models car_Models = new Car_Models();
//			car_Models.setId(Integer.parseInt(model_id));
//
//			parts.setCar_Models(car_Models);
//			parts.setPart(part);
//			parts.setQuantity(Integer.parseInt(quantity));
//			parts.setAmount(Double.parseDouble(amount));
//			parts.setParts_status(Stock_Status.INSTOCK);
//
//			insert_DAO_Interface.insertSparePart(parts);
//		}
//	}
//
//	@Override
//	public String insertAccessCodeAndSend(String username) {
//		// TODO Auto-generated method stub
//		List<MSK_Owner> msk_Owners = get_DAO_Interface.getMSKOwnerDetail(username);
//		String status = "failure";
//
//		if (!msk_Owners.isEmpty()) {
//			String secret;
//
//			Encrypt_Decrypt encrypt_Decrypt = new Encrypt_Decrypt();
//
//			if (!msk_Owners.get(0).getAccess_code().equals("0")) {
////				mailSenderService.sendAccessCode(msk_Owners.get(0).getEmail(),
////						encrypt_Decrypt.decrypt(msk_Owners.get(0).getAccess_code()));
//
//				status = "success";
//			} else {
//				Random random = new Random();
//				secret = "" + random.nextInt(999999);
//
//				msk_Owners.get(0).setAccess_code(encrypt_Decrypt.encrypt(secret));
//				update_DAO_Interface.updateMSKOwner(msk_Owners.get(0));
//
////				mailSenderService.sendAccessCode(msk_Owners.get(0).getEmail(), secret);
//
//				status = "success";
//			}
//		}
//
//		return status;
//	}

}
