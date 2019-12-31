package com.msk.automotive.dao.repositories;

import java.util.List;

import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.CustomerDetails;
import com.msk.automotive.service.entities.Location;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Notification;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.ServiceAdvisor;
import com.msk.automotive.service.entities.ServiceInvoiceCard;
import com.msk.automotive.service.entities.ServiceType;

public interface Get_DAO_Interface {

	List<CarBrands> getAllBrands();

	List<CarModels> getModelsByBrandId(Integer car_brands_id);

	List<CarModels> getModelsByBrandIdAndModel(Integer car_brands_id, String model);

	List<MSKOwner> getMSKOwnerDetail(String username);

	List<CarBrands> getBrandById(Integer brand_id);

	List<CarModels> getModelById(Integer model_id);

	List<CarBrands> getByBrand(String brand);

	List<CustomerDetails> getAllCustomerDetails();

	List<CustomerContactDetails> getCustomerContactDetails(Integer customer_id);

	List<ServiceInvoiceCard> getSericeInvoiceCard(Integer customer_id);

	List<Location> getLocation();

	List<ServiceType> getServiceType();

	List<ServiceInvoiceCard> getServiceInvoiceCards();

	List<ServiceInvoiceCard> getServiceInvoiceCardsByStatus(String service_card_status);

	String getLocationByCityId(Integer location_id);

	List<Parts> getSparePartsInStock(String stock_status);

	List<Parts> getSparePartsInStockById(String spare_part_id);

	List<Parts> getSparePartsAtParticularModel(String model_id);

	List<Parts> getSparePartsAtParticularModelParts(Integer model_id, String part);

	List<CustomerDetails> getExistingCustomerModelDetails(Integer car_models_id);

	List<ServiceAdvisor> getServiceAdvicers();

	List<Notification> getAllNotificationDetails();

	List<CustomerDetails> getCustomerRegistrationNo(String registration_no);

	List<CustomerDetails> getCustomerDetailByCustomerId(String customer_id);

	List<CustomerDetails> getCustomerDetailById(Integer id);

	List<Notification> getNotificationDetailsById(Integer notification_id);

	List<ServiceType> getServiceTypeById(Integer id);

	List<ServiceInvoiceCard> getSericeInvoiceCardByServiceId(String service_id);
}
