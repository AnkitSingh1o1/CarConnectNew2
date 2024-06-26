
//Authors: Ashwin Soni & Anand Karthick

package com.service;

import java.sql.SQLException;

import java.util.*;
import com.dao.*;
import com.dto.*;
import com.exception.*;
import com.model.*;
import com.utility.*;



public class AdminService {
	AdminDao dao = new AdminDaoImpl();
	 AddressDao addressDao = new AddressDaoImpl();
	    UserDao userDao = new UserDaoImpl();
	    ReservationPerCityDao reservationPerCityDao = new ReservationPerCityDaoImpl();
	// Total revenue service forwarded to AdminDao class for implementation
	public double getRevenue() throws SQLException, DatabaseConnectionException {
		return dao.getRevenue();
	}

	// vehicle revenue service
	public List<AdminDto> vehicleRevenue() throws SQLException, DatabaseConnectionException {
		return dao.vehicleRevenue();
	}

	public int addAdmin(Admin admin) throws SQLException, DatabaseConnectionException {
		return dao.registerAdmin(admin);
	}

	public List<Admin> findAll() throws SQLException, DatabaseConnectionException {
		return dao.findAll();
	}

	public void deactivateAdmin(int adminId) throws AdminNotFoundException, SQLException, DatabaseConnectionException {
		boolean isIdValid = dao.findOne(adminId);
		if (!isIdValid) {
			throw new AdminNotFoundException("Invalid adminId!");
		}
		dao.deactivateAdmin(adminId);
	}

	public void updateAdmin(int adminId, AdminUpdate admin) throws AdminNotFoundException, SQLException, DatabaseConnectionException {
		dao.updateAdmin(adminId,admin);
	}

	public boolean getAdminById(int adminId)throws AdminNotFoundException, SQLException, DatabaseConnectionException {
		if(!(dao.findOne(adminId)))
			throw new AdminNotFoundException("Invalid adminId!");
		return true;
	}

	public List<Customer> getCustomerWithNoReservation() throws SQLException, DatabaseConnectionException {
		return dao.getCustomerWithNoReservation();
	}

	public int getAdminIdByUsername(String username, String password) throws SQLException, AuthenticationException, DatabaseConnectionException {
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
