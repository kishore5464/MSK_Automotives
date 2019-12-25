package com.msk.automotive.business.interfaces;

import java.util.List;

import com.msk.automotive.service.pojo.Car_Brands_Pojo;
import com.msk.automotive.service.pojo.Car_Models_Pojo;
import com.msk.automotive.service.pojo.Customer_Details_Pojo;
import com.msk.automotive.service.pojo.Job_Card_Status_Pojo;
import com.msk.automotive.service.pojo.Location_Pojo;
import com.msk.automotive.service.pojo.Notifcation_Message_Pojo;
import com.msk.automotive.service.pojo.Notifcation_Pojo;
import com.msk.automotive.service.pojo.Service_Advicer_Pojo;
import com.msk.automotive.service.pojo.Service_Card_Pojo;
import com.msk.automotive.service.pojo.Service_Parts_Pojo;
import com.msk.automotive.service.pojo.Service_Type_Pojo;
import com.msk.automotive.service.pojo.Spare_Parts_Pojo;

public interface Get_Business_Interface {

	List<Car_Brands_Pojo> getAllBrands(String type);

	List<Car_Models_Pojo> getModels(String car_brands_id, String type);

	String getMSKOwnerDetail(String username, String password);

	List<Customer_Details_Pojo> getExistingCustomerDetails();

	List<Location_Pojo> getLocation();

	List<Service_Type_Pojo> getServiceType();

	String getServiceCardNo();

	List<Spare_Parts_Pojo> getSparePartsInStock(String stock_status);

	List<String> getSparePartsAtParticularModel(String model_id);

	String getVerifyAccessCode(String username, String access_code);

	Spare_Parts_Pojo getSparePartsAtParticularModelParts(String model_id, String part);

	List<Customer_Details_Pojo> getExistingCustomerModelDetails(String model_id);

	List<Notifcation_Message_Pojo> getServiceNotificationMessage();

	List<Service_Advicer_Pojo> getServiceAdvicers();

	Service_Card_Pojo getCustomerDetail(String customer_id);

	List<Notifcation_Pojo> getCustomerServiceNotification(String notification_id);

	List<Service_Parts_Pojo> getSparePartsAtParticularModelPojo(String model_id);

	List<Service_Parts_Pojo> getSparePartsAtParticularAmt(String part_id);

	List<Job_Card_Status_Pojo> getJobCardStatus(String invoice_status);

}
