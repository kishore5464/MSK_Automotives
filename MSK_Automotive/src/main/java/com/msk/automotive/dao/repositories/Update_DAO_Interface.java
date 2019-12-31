package com.msk.automotive.dao.repositories;

import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.ServiceInvoiceCard;

public interface Update_DAO_Interface {

	void updateBrandDetail(CarBrands car_Brands);

	void updateModelDetail(CarModels car_Models);

	void updateMSKOwner(MSKOwner msk_Owner);

	void updateSparePartsInStock(Parts parts);

	void updateExistingServiceCardStatus(ServiceInvoiceCard service_Invoice_Card);

}
