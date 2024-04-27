package com.dao;

import java.sql.*;
import java.util.*;

import com.dto.AdminDto;
import com.model.Admin;
import com.utility.DBConnection;
public class AdminDaoImpl implements AdminDao{


	@Override
	public double getRevenue() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT SUM(reservation_total_cost) as 'totalRevenue' FROM reservation WHERE reservation_status = 'completed'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		double totalRevenue = 0;
		 if (rst.next())
			totalRevenue = rst.getDouble("totalRevenue");
		DBConnection.dbClose();
		
		return totalRevenue;
		
	}

	@Override
	public List<AdminDto> vehicleRevenue() throws SQLException {
		Connection con = DBConnection.dbConnect();
		
		String sql = " SELECT vehicle_id, sum(reservation_total_cost) as 'vehicleRevenue' "
				+"FROM reservation GROUP BY vehicle_id ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		List<AdminDto>list = new ArrayList<>();
		
		while(rst.next()==true) {
			int vehicleId = rst.getInt("vehicle_id");
			int totalRevenue = rst.getInt("vehicleRevenue");
			
			AdminDto admin = new AdminDto(vehicleId, totalRevenue);
			list.add(admin);
			
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int save(Admin admin) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO admin(admin_id,admin_first_name,admin_last_name,"
				+"admin_email,admin_phone_number,admin_role,admin_join_date) VALUES (?,?,?,?,?,?,?)";	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,admin.getAdminId());
		pstmt.setString(2, admin.getAdminFirstName());
		pstmt.setString(3, admin.getAdminLastName());
		pstmt.setString(4, admin.getAdminEmail());
		pstmt.setString(5, admin.getAdminPhoneNumber());
		pstmt.setString(6, admin.getAdminRole());
		pstmt.setString(7, admin.getAdminJoinDate());
		
		int status = pstmt.executeUpdate();
		
		
		return status;
	}

	

}
