package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.AdminDto;
import com.model.Admin;
public interface AdminDao {

	//Returns total revenue by summing up all the total_cost of the reservation table with 'completed' status 
	double getRevenue() throws SQLException;
	//Returns total revenue earned by each vehicle
	List<AdminDto> vehicleRevenue() throws SQLException;
	int save(Admin admin) throws SQLException;
	

	
}
