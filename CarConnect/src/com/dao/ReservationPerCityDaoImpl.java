package com.dao;
import java.sql.*;

import java.util.*;
import com.dto.ReservationPerCity;
import com.dto.RevenuePerCity;
import com.exception.*;
import com.utility.DBConnection;
public class ReservationPerCityDaoImpl implements ReservationPerCityDao{
@Override
public List<ReservationPerCity>getReservationCountPerCity() throws SQLException,DatabaseConnectionException{
Connection con=DBConnection.dbConnect();
String sql="select a.address_city, count(r.reservation_id) as reservation_count from reservation r join customer c on r.customer_id = c.customer_id join address a on c.address_id = a.address_id group by upper(a.address_city) order by reservation_count desc";
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rst=pstmt.executeQuery();

List<ReservationPerCity> reservationPerCityList=new ArrayList<>();

while (rst.next()) {
	String city=rst.getString("address_city");
	int reservationCount=rst.getInt("reservation_count");
	ReservationPerCity reservationPerCity=new ReservationPerCity(city,reservationCount);
	reservationPerCityList.add(reservationPerCity);
}DBConnection.dbClose();
return reservationPerCityList;
}

@Override
public List<RevenuePerCity> getRevenuePerCity() throws SQLException, DatabaseConnectionException {
    Connection con = DBConnection.dbConnect();
    String sql = "SELECT a.address_city, SUM(r.reservation_total_cost) AS total_revenue FROM reservation r JOIN customer c ON r.customer_id = c.customer_id JOIN address a ON c.address_id = a.address_id GROUP BY UPPER(a.address_city) ORDER BY total_revenue DESC";
    PreparedStatement pstmt = con.prepareStatement(sql);
    ResultSet rst = pstmt.executeQuery();

    List<RevenuePerCity> revenuePerCityList = new ArrayList<>();

    while (rst.next()) {
        String city = rst.getString("address_city");
        double totalRevenue = rst.getDouble("total_revenue");
        RevenuePerCity revenuePerCity = new RevenuePerCity(city, totalRevenue);
        revenuePerCityList.add(revenuePerCity);
    }
    DBConnection.dbClose();
    return revenuePerCityList;
}
}