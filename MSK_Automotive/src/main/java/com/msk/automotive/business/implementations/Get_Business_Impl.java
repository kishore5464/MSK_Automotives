package com.msk.automotive.business.implementations;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.automotive.business.interfaces.Get_Business_Interface;
import com.msk.automotive.dao.repositories.CarBrand_Repository;
import com.msk.automotive.dao.repositories.CarModel_Repository;
import com.msk.automotive.dao.repositories.CustomerContactDetails_Repository;
import com.msk.automotive.dao.repositories.CustomerDetails_Repository;
import com.msk.automotive.dao.repositories.Location_Repository;
import com.msk.automotive.dao.repositories.MSKOwners_Repository;
import com.msk.automotive.dao.repositories.Parts_Repository;
import com.msk.automotive.dao.repositories.ServiceInvoiceCard_Repository;
import com.msk.automotive.dao.repositories.ServiceType_Repository;
import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.Location;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Notification;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.ServiceAdvisor;
import com.msk.automotive.service.entities.ServiceInvoiceCard;
import com.msk.automotive.service.entities.ServiceType;
import com.msk.automotive.service.pojo.CarBrands_Pojo;
import com.msk.automotive.service.pojo.CarModels_Pojo;
import com.msk.automotive.service.pojo.CustomerDetails_Pojo;
import com.msk.automotive.service.pojo.JobCardStatus_Pojo;
import com.msk.automotive.service.pojo.Location_Pojo;
import com.msk.automotive.service.pojo.NotifcationMessage_Pojo;
import com.msk.automotive.service.pojo.Notifcation_Pojo;
import com.msk.automotive.service.pojo.ServiceAdvicer_Pojo;
import com.msk.automotive.service.pojo.ServiceCard_Pojo;
import com.msk.automotive.service.pojo.ServiceParts_Pojo;
import com.msk.automotive.service.pojo.ServiceType_Pojo;
import com.msk.automotive.utilities.Encrypt_Decrypt;

@Service
public class Get_Business_Impl implements Get_Business_Interface {

	@Autowired
	private CarBrand_Repository carBrand_Repository;

	@Autowired
	private CarModel_Repository carModel_Repository;

	@Autowired
	private MSKOwners_Repository mSKOwners_Repository;

	@Autowired
	private CustomerDetails_Repository customerDetails_Repository;

	@Autowired
	private CustomerContactDetails_Repository customerContactDetails_Repository;

	@Autowired
	private ServiceInvoiceCard_Repository serviceInvoiceCard_Repository;

	@Autowired
	private Parts_Repository parts_Repository;

	@Autowired
	private Location_Repository location_Repository;

	@Autowired
	private ServiceType_Repository serviceType_Repository;

	@Override
	public List<CarBrands_Pojo> getAllBrands(String type) {
		List<CarBrands> brands = carBrand_Repository.findAll();
		List<CarBrands_Pojo> uiCarBrands = new ArrayList<CarBrands_Pojo>();

		if (!brands.isEmpty()) {
			for (int i = 0; i < brands.size(); i++) {
				CarBrands_Pojo CarBrands_Pojo = new CarBrands_Pojo();
				CarBrands_Pojo.setBrand_id(Integer.toString(brands.get(i).getId()));
				CarBrands_Pojo.setBrand(brands.get(i).getBrand().replace("+", " "));

				if (type.equals("service")) {
					if (brands.get(i).getLogo() == null || brands.get(i).getLogo().equals("")) {
						CarBrands_Pojo.setLogo("noimage");
					} else {
						CarBrands_Pojo.setLogo(brands.get(i).getLogo());
					}
				}

				uiCarBrands.add(CarBrands_Pojo);
			}
		}

		return uiCarBrands;
	}

	@Override
	public List<CarModels_Pojo> getModels(String CarBrands_id, String type) {
		List<CarModels> models = carModel_Repository.findByCarBrandsId(Integer.parseInt(CarBrands_id));
		List<CarModels_Pojo> uiCarModels_Pojos = new ArrayList<CarModels_Pojo>();

		if (!models.isEmpty()) {
			for (int i = 0; i < models.size(); i++) {
				CarModels_Pojo CarModels_Pojo = new CarModels_Pojo();
				CarModels_Pojo.setBrand_id(Integer.toString(models.get(i).getCarBrands().getId()));
				CarModels_Pojo.setModel_id(Integer.toString(models.get(i).getId()));
				CarModels_Pojo.setModel(models.get(i).getModel().replace("+", " "));

				if (type.equals("service")) {
					if (models.get(i).getImage() == null || models.get(i).getImage().equals("")) {
						CarModels_Pojo.setImage("noimage");
					} else {
						CarModels_Pojo.setImage(models.get(i).getImage());
					}
				}

				uiCarModels_Pojos.add(CarModels_Pojo);
			}
		}

		return uiCarModels_Pojos;
	}

	@Override
	public String getMSKOwnerDetail(String username, String password) {
		List<MSKOwner> MSKOwner = mSKOwners_Repository.findByEmail(username);
		Encrypt_Decrypt password_Encrypt_Decrypt = new Encrypt_Decrypt();
		String encrypt_password = password_Encrypt_Decrypt.encrypt(password);

		String status = null;

		if (!MSKOwner.isEmpty()) {
			if (encrypt_password.equals(MSKOwner.get(0).getPassword())) {
				status = "success";
			} else {
				status = "failure";
			}
		} else {
			status = "failure";
		}

		return status;
	}

	@Override
	public List<CustomerDetails_Pojo> getExistingCustomer_Details() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		List<Customer_Details> customer_Details = customerDetails_Repository.findAll();
		List<CustomerDetails_Pojo> customerDetails_Pojos = new ArrayList<CustomerDetails_Pojo>();

		if (!customer_Details.isEmpty()) {
			for (int i = 0; i < customer_Details.size(); i++) {
				CustomerDetails_Pojo customerDetails_Pojo = new CustomerDetails_Pojo();
				customerDetails_Pojo.setCustomer_id(customer_Details.get(i).getCustomer_id());
				customerDetails_Pojo.setFirst_name(customer_Details.get(i).getFirst_name());
				customerDetails_Pojo.setMobile(customer_Details.get(i).getMobile());
				customerDetails_Pojo.setGst_no(customer_Details.get(i).getGst_no());
				customerDetails_Pojo.setRegistration_no(customer_Details.get(0).getRegistration_no());

				Optional<CarModels> car_Model = carModel_Repository
						.findById(customer_Details.get(i).getCarModels().getId());
				customerDetails_Pojo.setModel(car_Model.get().getModel());

				List<ServiceInvoiceCard> ServiceInvoiceCards = serviceInvoiceCard_Repository
						.findByCustomer_Details(customer_Details.get(i).getId());
				customerDetails_Pojo.setExpire_service_date(dateFormat
						.format(ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getService_expire_date()));

				customerDetails_Pojos.add(customerDetails_Pojo);
			}
		}

		return customerDetails_Pojos;
	}

	@Override
	public List<Location_Pojo> getLocation() {
		List<Location> locations = location_Repository.findAll();
		List<Location_Pojo> location_Pojos = new ArrayList<Location_Pojo>();

		if (!locations.isEmpty()) {
			for (int i = 0; i < locations.size(); i++) {
				Location_Pojo location_Pojo = new Location_Pojo();
				location_Pojo.setId(Integer.toString(locations.get(i).getId()));
				location_Pojo.setCity(locations.get(i).getCity());

				location_Pojos.add(location_Pojo);
			}
		}

		return location_Pojos;
	}

	@Override
	public List<ServiceType_Pojo> getServiceType() {
		List<ServiceType> ServiceTypes = serviceType_Repository.findAll();
		List<ServiceType_Pojo> ServiceType_Pojos = new ArrayList<ServiceType_Pojo>();

		if (!ServiceTypes.isEmpty()) {
			for (int i = 0; i < ServiceTypes.size(); i++) {
				ServiceType_Pojo ServiceType_Pojo = new ServiceType_Pojo();
				ServiceType_Pojo.setId(Integer.toString(ServiceTypes.get(i).getId()));
				ServiceType_Pojo.setServiceType(ServiceTypes.get(i).getServiceType());

				ServiceType_Pojos.add(ServiceType_Pojo);
			}
		}

		return ServiceType_Pojos;
	}

	@Override
	public String getServiceCardNo() {
		List<ServiceInvoiceCard> ServiceInvoiceCards = serviceInvoiceCard_Repository.findAll();
		String service_card_id = null;

		if (!ServiceInvoiceCards.isEmpty()) {
			if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() <= 9) {
				service_card_id = "MSK 00" + ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId();
			} else if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() >= 10
					&& ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() <= 99) {
				service_card_id = "MSK 0" + ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId();
			} else if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() >= 100
					&& ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() <= 999) {
				service_card_id = "MSK " + ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId();
			}
		} else {
			service_card_id = "MSK 001";
		}

		return service_card_id;
	}

	@Override
	public List<Spare_Parts_Pojo> getSparePartsInStock(String StockStatus) {
		if (StockStatus.equals("notpurchased")) {
			StockStatus = "not_purchased";
		}

		List<Parts> spare_parts = parts_Repository.findByParts_status(StockStatus);
		List<Spare_Parts_Pojo> spare_Parts_Pojos = new ArrayList<Spare_Parts_Pojo>();

		if (!spare_parts.isEmpty()) {
			for (int i = 0; i < spare_parts.size(); i++) {
				Spare_Parts_Pojo spare_Parts_Pojo = new Spare_Parts_Pojo();

				Optional<CarModels> models = carModel_Repository.findById(spare_parts.get(i).getCarModels().getId());

				spare_Parts_Pojo.setId(Integer.toString(i + 1));
				spare_Parts_Pojo.setBrand(carBrand_Repository.findById(models.get().getCarBrands().getId()).get()
						.getBrand().replace("+", " "));
				spare_Parts_Pojo.setModel(models.get().getModel().replace("+", " "));
				spare_Parts_Pojo.setSpare_part_id(Integer.toString(spare_parts.get(i).getId()));
				spare_Parts_Pojo.setSpare_part_name(spare_parts.get(i).getPart());
				spare_Parts_Pojo.setQuantity(Integer.toString(spare_parts.get(i).getQuantity()));
				spare_Parts_Pojo.setPrice_per_unit(Double.toString(spare_parts.get(i).getAmount()));
				spare_Parts_Pojo.setTotal_price(
						Double.toString((spare_parts.get(i).getQuantity() * spare_parts.get(i).getAmount())));
				spare_Parts_Pojo.setCreated_date(spare_parts.get(i).getCreated_date());

				spare_Parts_Pojos.add(spare_Parts_Pojo);
			}
		}

		Collections.sort(spare_Parts_Pojos, new Spare_Parts_Pojo());

		return spare_Parts_Pojos;
	}

	@Override
	public List<String> getSparePartsAtParticularModel(String model_id) {
		List<Parts> parts = parts_Repository.findByCarModels(Integer.parseInt(model_id));
		List<String> parts_list = new ArrayList<String>();

		if (!parts.isEmpty()) {
			for (int i = 0; i < parts.size(); i++) {
				String part = parts.get(i).getPart();
				parts_list.add(part);
			}
		}

		return parts_list;
	}

	@Override
	public String getVerifyAccessCode(String username, String access_code) {
		List<MSKOwner> MSKOwners = mSKOwners_Repository.findByEmail(username);
		String status = "failure";

		if (!MSKOwners.isEmpty()) {
			Encrypt_Decrypt encrypt_Decrypt = new Encrypt_Decrypt();
			String access = encrypt_Decrypt.decrypt(MSKOwners.get(0).getAccess_code());
			if (access.equals(access_code)) {
				MSKOwners.get(0).setAccess_code("0");
				mSKOwners_Repository.save(MSKOwners.get(0));
				status = "success";
			}
		}

		return status;
	}

	public Spare_Parts_Pojo getSparePartsAtParticularModelParts(String model_id, String part) {
		List<Parts> spare_parts = parts_Repository.findByCarModelsAndPart(Integer.parseInt(model_id), part);
		Spare_Parts_Pojo spare_Parts_Pojo = new Spare_Parts_Pojo();

		if (!spare_parts.isEmpty()) {
			Optional<CarModels> models = carModel_Repository.findById(spare_parts.get(0).getCarModels().getId());

			spare_Parts_Pojo.setBrand(carModel_Repository.findByCarBrandsId(models.get().getCarBrands().getId()).get(0)
					.getCarBrands().getBrand().replace("+", " "));
			spare_Parts_Pojo.setId("1");
			spare_Parts_Pojo.setModel(models.get().getModel().replace("+", " "));
			spare_Parts_Pojo.setPrice_per_unit(Double.toString(spare_parts.get(0).getAmount()));
			spare_Parts_Pojo.setQuantity(Integer.toString(spare_parts.get(0).getQuantity()));
			spare_Parts_Pojo.setSpare_part_id(Integer.toString(spare_parts.get(0).getId()));
			spare_Parts_Pojo.setSpare_part_name(spare_parts.get(0).getPart());
			spare_Parts_Pojo.setTotal_price(
					Double.toString((spare_parts.get(0).getQuantity() * spare_parts.get(0).getAmount())));
		} else {
			spare_Parts_Pojo.setId("0");
		}

		return spare_Parts_Pojo;
	}

	@Override
	public List<CustomerDetails_Pojo> getExistingCustomerModelDetails(String model_id) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		List<Customer_Details> customer_Details = customerDetails_Repository
				.getExistingCustomerModelDetails(Integer.parseInt(model_id));
		List<CustomerDetails_Pojo> customerDetails_Pojos = new ArrayList<CustomerDetails_Pojo>();

		if (!customer_Details.isEmpty()) {
			for (int i = 0; i < customer_Details.size(); i++) {
				CustomerDetails_Pojo customerDetails_Pojo = new CustomerDetails_Pojo();
				customerDetails_Pojo.setCustomer_id(customer_Details.get(i).getCustomer_id());
				customerDetails_Pojo.setFirst_name(customer_Details.get(i).getFirst_name());
				customerDetails_Pojo.setMobile(customer_Details.get(i).getMobile());

				if (customer_Details.get(i).getGst_no() != null) {
					customerDetails_Pojo.setGst_no(customer_Details.get(i).getGst_no());
				} else {
					customerDetails_Pojo.setGst_no("GST NO NOT AVAILABLE");
				}

				customerDetails_Pojo.setRegistration_no(customer_Details.get(0).getRegistration_no());

				Optional<CarModels> car_Model = carModel_Repository
						.findById(customer_Details.get(i).getCarModels().getId());
				customerDetails_Pojo.setModel(car_Model.get().getModel());

				List<ServiceInvoiceCard> ServiceInvoiceCards = serviceInvoiceCard_Repository
						.getSericeInvoiceCard(customer_Details.get(i).getId());

				if (!ServiceInvoiceCards.isEmpty()) {
					customerDetails_Pojo.setExpire_service_date(dateFormat
							.format(ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getService_expire_date()));
				} else {
					customerDetails_Pojo.setExpire_service_date("SERVICE EXPIRE DATE NOT AVAILABLE");
				}

				customerDetails_Pojos.add(customerDetails_Pojo);
			}
		}

		return customerDetails_Pojos;
	}

	public List<NotifcationMessage_Pojo> getServiceNotificationMessage() {
		// TODO Auto-generated method stub
		List<Notification> notification = .getAllNotificationDetails();
		List<NotifcationMessage_Pojo> notifcationMessage_Pojos = new ArrayList<NotifcationMessage_Pojo>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (!notification.isEmpty()) {
			for (int i = 0; i < notification.size(); i++) {
				if (dateFormat.format(notification.get(i).getDob()).substring(5, 9)
						.equals(dateFormat.format(new Date()).substring(5, 9))) {
					NotifcationMessage_Pojo notifcationMessage_Pojo = new NotifcationMessage_Pojo();
					notifcationMessage_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));
					notifcationMessage_Pojo
							.setMessage(notification.get(i).getCustomer_name() + " has celebrating his birthday! ");

					notifcationMessage_Pojos.add(notifcationMessage_Pojo);
				}

				Date oneDay = new Date();
				Calendar oneDayCalendar = Calendar.getInstance();
				oneDayCalendar.setTime(oneDay);
				oneDayCalendar.add(Calendar.DATE, 1);
				oneDay = oneDayCalendar.getTime();

				Date twoDay = new Date();
				Calendar twoDayCalendar = Calendar.getInstance();
				twoDayCalendar.setTime(twoDay);
				twoDayCalendar.add(Calendar.DATE, 2);
				twoDay = twoDayCalendar.getTime();

				// TODAY
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(new Date()).substring(5, 9))) {
					NotifcationMessage_Pojo notifcationMessage_Pojo = new NotifcationMessage_Pojo();
					notifcationMessage_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));
					notifcationMessage_Pojo
							.setMessage(notification.get(i).getCustomer_name() + "'s service EXPIRES Today!");

					notifcationMessage_Pojos.add(notifcationMessage_Pojo);
				}

				// TOMORROW
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(oneDay).substring(5, 9))) {
					NotifcationMessage_Pojo notifcationMessage_Pojo = new NotifcationMessage_Pojo();
					notifcationMessage_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));
					notifcationMessage_Pojo
							.setMessage(notification.get(i).getCustomer_name() + "'s service EXPIRES Tomorrow!");

					notifcationMessage_Pojos.add(notifcationMessage_Pojo);
				}

				// DAY AFTER TOMORROW
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(twoDay).substring(5, 9))) {
					NotifcationMessage_Pojo notifcationMessage_Pojo = new NotifcationMessage_Pojo();
					notifcationMessage_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));
					notifcationMessage_Pojo.setMessage(
							notification.get(i).getCustomer_name() + "'s service EXPIRES Day After Tomorrow!");

					notifcationMessage_Pojos.add(notifcationMessage_Pojo);
				}
			}
		}

		return notifcationMessage_Pojos;
	}

	@Override
	public List<ServiceAdvicer_Pojo> getServiceAdvicers() {
		// TODO Auto-generated method stub
		List<ServiceAdvisor> service_advicer_list = get_DAO_Interface.getServiceAdvicers();
		List<ServiceAdvicer_Pojo> serviceAdvicer_Pojos = new ArrayList<ServiceAdvicer_Pojo>();

		if (!service_advicer_list.isEmpty()) {
			for (int i = 0; i < service_advicer_list.size(); i++) {
				ServiceAdvicer_Pojo advicer_Pojo = new ServiceAdvicer_Pojo();
				advicer_Pojo.setId(Integer.toString(service_advicer_list.get(i).getId()));
				advicer_Pojo.setName(service_advicer_list.get(i).getName());
				advicer_Pojo.setMobile(service_advicer_list.get(i).getMobile());

				serviceAdvicer_Pojos.add(advicer_Pojo);
			}
		}

		return serviceAdvicer_Pojos;
	}

	@Override
	public ServiceCard_Pojo getCustomerDetail(String customer_id) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ServiceCard_Pojo serviceCard_Pojo = new ServiceCard_Pojo();

		List<Customer_Details> customer_Details_List = get_DAO_Interface.getCustomerDetailByCustomerId(customer_id);

		if (!customer_Details_List.isEmpty()) {

			serviceCard_Pojo.setCustomer_id(customer_Details_List.get(0).getCustomer_id());

			if (customer_Details_List.get(0).getLast_name() == null) {
				serviceCard_Pojo.setName(customer_Details_List.get(0).getFirst_name());
			} else {
				serviceCard_Pojo.setName(customer_Details_List.get(0).getFirst_name() + " "
						+ customer_Details_List.get(0).getLast_name());

			}
			serviceCard_Pojo.setMobile(customer_Details_List.get(0).getMobile());
			serviceCard_Pojo.setRegistration_no(customer_Details_List.get(0).getRegistration_no());
			serviceCard_Pojo.setModel_id(Integer.toString(customer_Details_List.get(0).getCarModels().getId()));

			if (customer_Details_List.get(0).getEngine_no() != null) {
				serviceCard_Pojo.setEngine_no(customer_Details_List.get(0).getEngine_no());
			} else {
				serviceCard_Pojo.setEngine_no("not available");
			}

			if (customer_Details_List.get(0).getPolicy_expires_date() != null) {
				serviceCard_Pojo.setPolicy_expires_date(
						dateFormat.format(customer_Details_List.get(0).getPolicy_expires_date()));
			} else {
				serviceCard_Pojo.setPolicy_expires_date("not available");
			}

			serviceCard_Pojo.setGst_no(customer_Details_List.get(0).getGst_no());

			List<CustomerContactDetails> CustomerContactDetails = get_DAO_Interface
					.getCustomerContactDetails(customer_Details_List.get(0).getId());
			if (!CustomerContactDetails.isEmpty()) {

				if (CustomerContactDetails.get(0).getAddress_line_2() != null) {
					serviceCard_Pojo.setAddress_line(CustomerContactDetails.get(0).getAddress_line_1() + ", "
							+ CustomerContactDetails.get(0).getAddress_line_2());
				} else {
					serviceCard_Pojo.setAddress_line(CustomerContactDetails.get(0).getAddress_line_1());
				}

				serviceCard_Pojo.setCity(
						get_DAO_Interface.getLocationByCityId(CustomerContactDetails.get(0).getLocation().getId()));
				serviceCard_Pojo.setPincode(Integer.toString(CustomerContactDetails.get(0).getPincode()));
			}

			List<ServiceInvoiceCard> ServiceInvoiceCards = get_DAO_Interface.getServiceInvoiceCards();

			if (!ServiceInvoiceCards.isEmpty()) {
				if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() < 9) {
					serviceCard_Pojo.setInvoice_no(
							"MSKS00" + (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() + 1));
				} else if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() >= 9
						&& ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() < 99) {
					serviceCard_Pojo.setInvoice_no(
							"MSKS0" + (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() + 1));
				} else if (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() >= 99
						&& ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() < 999) {
					serviceCard_Pojo.setInvoice_no(
							"MSKS" + (ServiceInvoiceCards.get(ServiceInvoiceCards.size() - 1).getId() + 1));
				}
			} else {
				serviceCard_Pojo.setInvoice_no("MSKS001");
			}
		}

		return serviceCard_Pojo;
	}

	@Override
	public List<Notifcation_Pojo> getCustomerServiceNotification(String notification_id) {
		// TODO Auto-generated method stub
		List<Notifcation_Pojo> notifcation_Pojos = new ArrayList<Notifcation_Pojo>();
		List<Notification> notification;

		if (notification_id.equals("0")) {
			notification = get_DAO_Interface.getAllNotificationDetails();
		} else {
			notification = get_DAO_Interface.getNotificationDetailsById(Integer.parseInt(notification_id));
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (!notification.isEmpty()) {
			for (int i = 0; i < notification.size(); i++) {
				if (dateFormat.format(notification.get(i).getDob()).substring(5, 9)
						.equals(dateFormat.format(new Date()).substring(5, 9))) {
					Notifcation_Pojo notifcation_Pojo = new Notifcation_Pojo();
					notifcation_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));

					notifcation_Pojo.setCustomer_name(notification.get(i).getCustomer_name());
					notifcation_Pojo.setMobile(notification.get(i).getMobile());
					notifcation_Pojo.setRegistration_no(notification.get(i).getRegistration_no());
					notifcation_Pojo.setDob(dateFormat.format(notification.get(i).getDob()));
					notifcation_Pojo.setCar_brand(notification.get(i).getCar_brand());
					notifcation_Pojo.setCar_model(notification.get(i).getCar_model());
					notifcation_Pojo
							.setService_expire_date(dateFormat.format(notification.get(i).getService_expire_date()));

					notifcation_Pojos.add(notifcation_Pojo);
				}

				Date oneDay = new Date();
				Calendar oneDayCalendar = Calendar.getInstance();
				oneDayCalendar.setTime(oneDay);
				oneDayCalendar.add(Calendar.DATE, 1);
				oneDay = oneDayCalendar.getTime();

				Date twoDay = new Date();
				Calendar twoDayCalendar = Calendar.getInstance();
				twoDayCalendar.setTime(twoDay);
				twoDayCalendar.add(Calendar.DATE, 2);
				twoDay = twoDayCalendar.getTime();

				// TODAY
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(new Date()).substring(5, 9))) {
					Notifcation_Pojo notifcation_Pojo = new Notifcation_Pojo();
					notifcation_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));

					notifcation_Pojo.setCustomer_name(notification.get(i).getCustomer_name());
					notifcation_Pojo.setMobile(notification.get(i).getMobile());
					notifcation_Pojo.setRegistration_no(notification.get(i).getRegistration_no());
					notifcation_Pojo.setDob(dateFormat.format(notification.get(i).getDob()));
					notifcation_Pojo.setCar_brand(notification.get(i).getCar_brand());
					notifcation_Pojo.setCar_model(notification.get(i).getCar_model());
					notifcation_Pojo
							.setService_expire_date(dateFormat.format(notification.get(i).getService_expire_date()));

					notifcation_Pojos.add(notifcation_Pojo);
				}

				// TOMORROW
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(oneDay).substring(5, 9))) {
					Notifcation_Pojo notifcation_Pojo = new Notifcation_Pojo();
					notifcation_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));

					notifcation_Pojo.setCustomer_name(notification.get(i).getCustomer_name());
					notifcation_Pojo.setMobile(notification.get(i).getMobile());
					notifcation_Pojo.setRegistration_no(notification.get(i).getRegistration_no());
					notifcation_Pojo.setDob(dateFormat.format(notification.get(i).getDob()));
					notifcation_Pojo.setCar_brand(notification.get(i).getCar_brand());
					notifcation_Pojo.setCar_model(notification.get(i).getCar_model());
					notifcation_Pojo
							.setService_expire_date(dateFormat.format(notification.get(i).getService_expire_date()));

					notifcation_Pojos.add(notifcation_Pojo);
				}

				// DAY AFTER TOMORROW
				if (dateFormat.format(notification.get(i).getService_expire_date()).substring(5, 9)
						.equals(dateFormat.format(twoDay).substring(5, 9))) {
					Notifcation_Pojo notifcation_Pojo = new Notifcation_Pojo();
					notifcation_Pojo.setNotification_id(Integer.toString(notification.get(i).getId()));

					notifcation_Pojo.setCustomer_name(notification.get(i).getCustomer_name());
					notifcation_Pojo.setMobile(notification.get(i).getMobile());
					notifcation_Pojo.setRegistration_no(notification.get(i).getRegistration_no());
					notifcation_Pojo.setDob(dateFormat.format(notification.get(i).getDob()));
					notifcation_Pojo.setCar_brand(notification.get(i).getCar_brand());
					notifcation_Pojo.setCar_model(notification.get(i).getCar_model());
					notifcation_Pojo
							.setService_expire_date(dateFormat.format(notification.get(i).getService_expire_date()));

					notifcation_Pojos.add(notifcation_Pojo);
				}
			}
		}

		return notifcation_Pojos;
	}

	public List<ServiceParts_Pojo> getSparePartsAtParticularModelPojo(String model_id) {
		// TODO Auto-generated method stub
		List<Parts> parts = get_DAO_Interface.getSparePartsAtParticularModel(model_id);
		List<ServiceParts_Pojo> parts_list = new ArrayList<ServiceParts_Pojo>();

		if (!parts.isEmpty()) {
			for (int i = 0; i < parts.size(); i++) {
				ServiceParts_Pojo part = new ServiceParts_Pojo();
				part.setPart_id(Integer.toString(parts.get(i).getId()));
				part.setPart(parts.get(i).getPart());

				part.setQuantity(Integer.toString(parts.get(i).getQuantity()));
				part.setAmount(Double.toString(parts.get(i).getAmount()));

				parts_list.add(part);
			}
		}

		return parts_list;
	}

	@Override
	public List<ServiceParts_Pojo> getSparePartsAtParticularAmt(String part_id) {
		// TODO Auto-generated method stub
		List<Parts> parts = get_DAO_Interface.getSparePartsInStockById(part_id);
		List<ServiceParts_Pojo> parts_list = new ArrayList<ServiceParts_Pojo>();

		if (!parts.isEmpty()) {
			for (int i = 0; i < parts.size(); i++) {
				ServiceParts_Pojo part = new ServiceParts_Pojo();
				part.setPart_id(Integer.toString(parts.get(i).getId()));
				part.setPart(parts.get(i).getPart());

				part.setQuantity(Integer.toString(parts.get(i).getQuantity()));
				part.setAmount(Double.toString(parts.get(i).getAmount()));

				parts_list.add(part);
			}
		}

		return parts_list;
	}

	@Override
	public List<JobCardStatus_Pojo> getJobCardStatus(String invoice_status) {
		// TODO Auto-generated method stub
		List<ServiceInvoiceCard> ServiceInvoiceCard = get_DAO_Interface.getServiceInvoiceCardsByStatus(invoice_status);
		List<JobCardStatus_Pojo> jobCardStatus_Pojos = new ArrayList<JobCardStatus_Pojo>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (!ServiceInvoiceCard.isEmpty()) {
			for (int i = 0; i < ServiceInvoiceCard.size(); i++) {
				JobCardStatus_Pojo jobCardStatus_Pojo = new JobCardStatus_Pojo();

				List<Customer_Details> customer = get_DAO_Interface
						.getCustomerDetailById(ServiceInvoiceCard.get(i).getCustomer_Details().getId());
				List<CarModels> models = get_DAO_Interface.getModelById(customer.get(0).getCarModels().getId());
				List<CarBrands> brands = get_DAO_Interface.getBrandById(models.get(0).getCarBrands().getId());
				List<ServiceType> ServiceType = get_DAO_Interface
						.getServiceTypeById(ServiceInvoiceCard.get(i).getServiceType().getId());

				jobCardStatus_Pojo.setJob_card_id(ServiceInvoiceCard.get(i).getService_id());
				jobCardStatus_Pojo.setBrand(brands.get(0).getBrand());
				jobCardStatus_Pojo.setModel(models.get(0).getModel());
				jobCardStatus_Pojo.setCardStatus(ServiceInvoiceCard.get(i).getCardStatus().toString());

				if (customer.get(0).getLast_name() == null) {
					jobCardStatus_Pojo.setCustomer_name(customer.get(0).getFirst_name());
				} else {
					jobCardStatus_Pojo
							.setCustomer_name(customer.get(0).getFirst_name() + " " + customer.get(0).getLast_name());
				}

				jobCardStatus_Pojo.setCustomer_mobile(customer.get(0).getMobile());
				jobCardStatus_Pojo.setRegistration_no(customer.get(0).getRegistration_no());
				jobCardStatus_Pojo.setServiceType(ServiceType.get(0).getServiceType());
				jobCardStatus_Pojo.setTotal_amount(Double.toString(ServiceInvoiceCard.get(i).getTotal_amount()));
				jobCardStatus_Pojo
						.setService_date(dateFormat.format(ServiceInvoiceCard.get(i).getCurrent_service_date()));

				jobCardStatus_Pojos.add(jobCardStatus_Pojo);
			}
		}
		return jobCardStatus_Pojos;
	}

}
