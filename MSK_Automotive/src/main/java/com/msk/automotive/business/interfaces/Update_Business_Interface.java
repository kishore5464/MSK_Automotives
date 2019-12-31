package com.msk.automotive.business.interfaces;

import java.util.List;

import com.msk.automotive.service.pojo.ServiceCard_Pojo;
import com.msk.automotive.service.pojo.ServiceParts_Pojo;

public interface Update_Business_Interface {

	String updateMSKOwnerPassword(String username, String password);

	void updateSparePartsInStock(String spare_part_id, String quantity, String price_per_unit);

	ServiceCard_Pojo updateExistingServiceCardStatus(String service_type, String invoice_no, String process_type);

	List<ServiceParts_Pojo> updateStockPartsAndStatus(String model_id, ServiceParts_Pojo service_Parts_Pojo);

}
