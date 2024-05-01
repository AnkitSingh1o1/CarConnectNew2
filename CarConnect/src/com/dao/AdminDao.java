
//Author: Ashwin Soni

package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.AdminDto;
import com.dto.AdminUpdate;
import com.model.Admin;
import com.model.Customer;


public interface AdminDao {

//Returns total revenue by summing up all the total_cost of the reservation table with 'completed' status 
	double getRevenue() throws SQLException;

//Returns total revenue earned by each vehicle
	List<AdminDto> vehicleRevenue() throws SQLException;

//Add admin data to database
	int registerAdmin(Admin admin) throws SQLException;

//Lists all Admins
	List<Admin> findAll() throws SQLException;

//Finds admin by adminId
	boolean findOne(int adminId) throws SQLException;

//Deactivates admin with given adminId
	void deactivateAdmin(int adminId) throws SQLException;
	
//Updates Admin Details
	void updateAdmin(int adminId, AdminUpdate admin) throws SQLException;
	
//Lists customers wtih no reservations
	List<Customer> getCustomerWithNoReservation() throws SQLException;
	
//Fetch adminId by username
	int getAdminIdByUsername(String username, String password) throws SQLException;



	

}
