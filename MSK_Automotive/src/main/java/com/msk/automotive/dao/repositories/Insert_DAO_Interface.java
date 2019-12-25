package com.msk.automotive.dao.repositories;

import com.msk.automotive.service.entities.Car_Brands;
import com.msk.automotive.service.entities.Car_Models;
import com.msk.automotive.service.entities.Customer_Contact_Details;
import com.msk.automotive.service.entities.Customer_Details;
import com.msk.automotive.service.entities.MSK_Owner;
import com.msk.automotive.service.entities.Parts;

public interface Insert_DAO_Interface {

	void insertCarBrand(Car_Brands car_Brands);

	void insertCarModel(Car_Models car_Models);

	void insertCustomerDetails(Customer_Details customer_Details, Customer_Contact_Details customer_Contact_Details);

	void insertSparePart(Parts parts);

	void insertAccessCodeAndSend(MSK_Owner msk_Owner);

}
