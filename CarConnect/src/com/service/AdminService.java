package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dto.AdminDto;
import com.model.Admin;

public class AdminService {
	AdminDao dao = new AdminDaoImpl();
	
	//Total revenue service forwarded to AdminDao class for implementation
	public double getRevenue() throws SQLException {
		return dao.getRevenue();
	}
	
	//vehicle revenue service
	public List<AdminDto> vehicleRevenue() throws SQLException {
		
		return dao.vehicleRevenue();
	}
	

	public int addAdmin(Admin admin) throws SQLException {
		
		return dao.save(admin);
	}
	

}
