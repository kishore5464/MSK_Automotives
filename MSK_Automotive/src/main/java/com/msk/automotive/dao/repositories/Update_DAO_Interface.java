package com.msk.automotive.dao.repositories;

import com.msk.automotive.service.entities.Car_Brands;
import com.msk.automotive.service.entities.Car_Models;
import com.msk.automotive.service.entities.MSK_Owner;
import com.msk.automotive.service.entities.Parts;
import com.msk.automotive.service.entities.Service_Invoice_Card;

public interface Update_DAO_Interface {

	void updateBrandDetail(Car_Brands car_Brands);

	void updateModelDetail(Car_Models car_Models);

	void updateMSKOwner(MSK_Owner msk_Owner);

	void updateSparePartsInStock(Parts parts);

	void updateExistingServiceCardStatus(Service_Invoice_Card service_Invoice_Card);

}
