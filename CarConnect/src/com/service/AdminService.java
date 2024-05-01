
//Author: Ashwin Soni

package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dto.AdminDto;
import com.dto.AdminUpdate;
import com.exception.AdminNotFoundException;
import com.exception.AuthenticationException;
import com.model.Admin;
import com.model.Customer;
import com.utility.VehicleRevenueAsc;
import com.utility.VehicleRevenueDsc;


public class AdminService {
	AdminDao dao = new AdminDaoImpl();

	// Total revenue service forwarded to AdminDao class for implementation
	public double getRevenue() throws SQLException {
		return dao.getRevenue();
	}

	// vehicle revenue service
	public List<AdminDto> vehicleRevenue() throws SQLException {
		return dao.vehicleRevenue();
	}

	public int addAdmin(Admin admin) throws SQLException {
		return dao.registerAdmin(admin);
	}

	public List<Admin> findAll() throws SQLException {
		return dao.findAll();
	}

	public void deactivateAdmin(int adminId) throws AdminNotFoundException, SQLException {
		boolean isIdValid = dao.findOne(adminId);
		if (!isIdValid) {
			throw new AdminNotFoundException("Invalid adminId!");
		}
		dao.deactivateAdmin(adminId);
	}

	public void updateAdmin(int adminId, AdminUpdate admin) throws AdminNotFoundException, SQLException {
		dao.updateAdmin(adminId,admin);
	}

	public boolean getAdminById(int adminId)throws AdminNotFoundException, SQLException {
		if(!(dao.findOne(adminId)))
			throw new AdminNotFoundException("Invalid adminId!");
		return true;
	}

	public List<Customer> getCustomerWithNoReservation() throws SQLException {
		return dao.getCustomerWithNoReservation();
	}

	public int getAdminIdByUsername(String username, String password) throws SQLException, AuthenticationException {
		 int isPresent = dao.getAdminIdByUsername(username, password);
		 if(isPresent == 0) {
			 throw new AuthenticationException("Invalid Username or Password!");
		 }
		 return isPresent;
	}

	public List<AdminDto> sortVehicleRevenue(List<AdminDto> list,String direction) {
		if(direction.equalsIgnoreCase("ASC")) {
			Collections.sort(list,new VehicleRevenueAsc());
		}
		else
		if(direction.equalsIgnoreCase("DESC")) {
			Collections.sort(list,new VehicleRevenueDsc());
		}
		return list;
	}



}
