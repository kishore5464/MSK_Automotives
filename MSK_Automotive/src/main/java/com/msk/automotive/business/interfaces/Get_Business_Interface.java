package com.msk.automotive.business.interfaces;

import java.util.List;

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
import com.msk.automotive.service.pojo.SpareParts_Pojo;

public interface Get_Business_Interface {

	List<CarBrands_Pojo> getAllBrands(String type);

	List<CarModels_Pojo> getModels(String car_brands_id, String type);

	String getMSKOwnerDetail(String username, String password);

	List<CustomerDetails_Pojo> getExistingCustomerDetails();

	List<Location_Pojo> getLocation();

	List<ServiceType_Pojo> getServiceType();

	String getServiceCardNo();

	List<SpareParts_Pojo> getSparePartsInStock(String stock_status);

	List<String> getSparePartsAtParticularModel(String model_id);

	String getVerifyAccessCode(String username, String access_code);

	SpareParts_Pojo getSparePartsAtParticularModelParts(String model_id, String part);

	List<CustomerDetails_Pojo> getExistingCustomerModelDetails(String model_id);

	List<NotifcationMessage_Pojo> getServiceNotificationMessage();

	List<ServiceAdvicer_Pojo> getServiceAdvicers();

	ServiceCard_Pojo getCustomerDetail(String customer_id);

	List<Notifcation_Pojo> getCustomerServiceNotification(String notification_id);

	List<ServiceParts_Pojo> getSparePartsAtParticularModelPojo(String model_id);

	List<ServiceParts_Pojo> getSparePartsAtParticularAmt(String part_id);

	List<JobCardStatus_Pojo> getJobCardStatus(String invoice_status);

}
