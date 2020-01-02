package com.msk.automotive.business.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.dao.repositories.CarBrand_Repository;
import com.msk.automotive.dao.repositories.CarModel_Repository;
import com.msk.automotive.dao.repositories.CustomerContactDetails_Repository;
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

@Service
public class Insert_Business_Impl implements Insert_Business_Interface {

	@Autowired
	private CarBrand_Repository carBrand_Repository;

	@Autowired
	private CarModel_Repository carModel_Repository;

	@Autowired
	private CustomerContactDetails_Repository update_DAO_Interface;

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
//	public Service_Card_Pojo insertCustomerDetail(String model_id, String first_name, String last_name, String mobile,
//			String email, String dob, String registration_no, String gst_no, String address_line_1,
//			String address_line_2, String location_id, String pincode) {
//		// TODO Auto-generated method stub
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Service_Card_Pojo service_Card_Pojo = new Service_Card_Pojo();
//
//		List<Customer_Details> customer_Details_List = get_DAO_Interface.getCustomerRegistrationNo(registration_no);
//
//		if (customer_Details_List.isEmpty()) {
//			Customer_Details customer_Details = new Customer_Details();
//
//			Car_Models car_Models = new Car_Models();
//			car_Models.setId(Integer.parseInt(model_id));
//
//			customer_Details.setCar_Models(car_Models);
//
//			List<Customer_Details> customer = get_DAO_Interface.getAllCustomerDetails();
//
//			if (!customer.isEmpty()) {
//				if (customer.get(customer.size() - 1).getId() <= 9) {
//					customer_Details.setCustomer_id("MSKC00" + customer.get(customer.size() - 1).getId());
//				} else if (customer.get(customer.size() - 1).getId() >= 10
//						&& customer.get(customer.size() - 1).getId() <= 99) {
//					customer_Details.setCustomer_id("MSKC0" + customer.get(customer.size() - 1).getId());
//				} else if (customer.get(customer.size() - 1).getId() >= 100
//						&& customer.get(customer.size() - 1).getId() <= 999) {
//					customer_Details.setCustomer_id("MSKC" + customer.get(customer.size() - 1).getId());
//				}
//			} else {
//				customer_Details.setCustomer_id("MSKC001");
//			}
//
//			customer_Details.setFirst_name(first_name);
//			customer_Details.setLast_name(last_name);
//			customer_Details.setMobile(mobile);
//			customer_Details.setEmail(email);
//
//			try {
//				customer_Details.setDob(dateFormat.parse(dob));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			customer_Details.setRegistration_no(registration_no);
//			customer_Details.setGst_no(gst_no);
//
//			Customer_Contact_Details customer_Contact_Details = new Customer_Contact_Details();
//
//			Location location = new Location();
//			location.setId(Integer.parseInt(location_id));
//			customer_Contact_Details.setLocation(location);
//
//			customer_Contact_Details.setAddress_line_1(address_line_1);
//			customer_Contact_Details.setAddress_line_2(address_line_2);
//			customer_Contact_Details.setPincode(Integer.parseInt(pincode));
//
//			insert_DAO_Interface.insertCustomerDetails(customer_Details, customer_Contact_Details);
//
//			if (address_line_2 != null) {
//				service_Card_Pojo.setAddress_line(address_line_1 + ", " + address_line_2);
//			} else {
//				service_Card_Pojo.setAddress_line(address_line_1);
//			}
//
//			service_Card_Pojo.setCity(get_DAO_Interface.getLocationByCityId(Integer.parseInt(location_id)));
//			service_Card_Pojo.setName(first_name + " " + last_name);
//			service_Card_Pojo.setGst_no(gst_no);
//
//			List<Service_Invoice_Card> service_Invoice_Cards = get_DAO_Interface.getServiceInvoiceCards();
//
//			if (!service_Invoice_Cards.isEmpty()) {
//				if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 9) {
//					service_Card_Pojo.setInvoice_no(
//							"MSKS00" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
//				} else if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() >= 10
//						&& service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 99) {
//					service_Card_Pojo.setInvoice_no(
//							"MSKS0" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
//				} else if (service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() >= 100
//						&& service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId() <= 999) {
//					service_Card_Pojo.setInvoice_no(
//							"MSKS" + service_Invoice_Cards.get(service_Invoice_Cards.size() - 1).getId());
//				}
//			} else {
//				service_Card_Pojo.setInvoice_no("MSKS001");
//			}
//
//			service_Card_Pojo.setMobile(mobile);
//			service_Card_Pojo.setPincode(pincode);
//			service_Card_Pojo.setRegistration_no(registration_no);
//		}
//
//		return service_Card_Pojo;
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
