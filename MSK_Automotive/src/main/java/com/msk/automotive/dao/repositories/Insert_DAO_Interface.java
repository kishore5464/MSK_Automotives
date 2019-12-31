package com.msk.automotive.dao.repositories;

import com.msk.automotive.service.entities.CarBrands;
import com.msk.automotive.service.entities.CarModels;
import com.msk.automotive.service.entities.CustomerContactDetails;
import com.msk.automotive.service.entities.CustomerDetails;
import com.msk.automotive.service.entities.MSKOwner;
import com.msk.automotive.service.entities.Parts;

public interface Insert_DAO_Interface {

	void insertCarBrand(CarBrands car_Brands);

	void insertCarModel(CarModels car_Models);

	void insertCustomerDetails(CustomerDetails customer_Details, CustomerContactDetails customer_Contact_Details);

	void insertSparePart(Parts parts);

	void insertAccessCodeAndSend(MSKOwner msk_Owner);

}
