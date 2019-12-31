package com.msk.automotive.business.implementations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Insert_Business_Interface;
import com.msk.automotive.dao.repositories.Get_DAO_Interface;
import com.msk.automotive.dao.repositories.Insert_DAO_Interface;
import com.msk.automotive.dao.repositories.Update_DAO_Interface;
import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.CustomerDetails;
import com.msk.automotive.service.entities.Location;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.ServiceInvoiceCard;
import com.msk.automotive.service.entities.StockStatus;
import com.msk.automotive.service.pojo.Service_Card_Pojo;
import com.msk.automotive.utilities.Encrypt_Decrypt;

@Service
public class Insert_Business_Impl{ //implements Insert_Business_Interface {

//	@Autowired
//	private Get_DAO_Interface get_DAO_Interface;
//
//	@Autowired
//	private Insert_DAO_Interface insert_DAO_Interface;
//
//	@Autowired
//	private Update_DAO_Interface update_DAO_Interface;
//
////	@Autowired
////	MailSenderService mailSenderService;
//
//	@Override
//	public void insertOrUpdateBrandLogo(String brand_id, String logo) {
//		// TODO Auto-generated method stub
//		List<Car_Brands> brand = get_DAO_Interface.getBrandById(Integer.parseInt(brand_id));
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
//	public void insertCarBrand(String brand, String logo) {
//		// TODO Auto-generated method stub
//		List<Car_Brands> brands = get_DAO_Interface.getByBrand(brand);
//
//		if (brands.isEmpty()) {
//			Car_Brands car_Brands = new Car_Brands();
//			car_Brands.setBrand(brand);
//			car_Brands.setLogo(logo);
//
//			insert_DAO_Interface.insertCarBrand(car_Brands);
//		}
//	}
//
//	@Override
//	public void insertCarModel(String brand_id, String model, String image) {
//		// TODO Auto-generated method stub
//		List<Car_Models> models = get_DAO_Interface.getModelsByBrandIdAndModel(Integer.parseInt(brand_id), model);
//
//		if (models.isEmpty()) {
//			Car_Brands car_Brands = new Car_Brands();
//			car_Brands.setId(Integer.parseInt(brand_id));
//
//			Car_Models car_Models = new Car_Models();
//			car_Models.setCar_Brands(car_Brands);
//			car_Models.setModel(model);
//			car_Models.setImage(image);
//
//			insert_DAO_Interface.insertCarModel(car_Models);
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
