//Author : Anand Karthick

package com.dao;
import java.sql.*;


import java.util.*;
import com.dto.*;
import com.exception.*;
import com.utility.*;
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
    
    //Group by, Order by, Join
    
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

public List<VendorsByCityDto> getVendorsByCity() throws SQLException, DatabaseConnectionException {
    Connection con = DBConnection.dbConnect();
    String sql = "SELECT a.address_city, v.vendor_id, v.vendor_first_name, v.vendor_last_name, v.vendor_email, v.vendor_phone_number, v.vendor_registration_date, a.address_city FROM Vendor v JOIN Address a ON v.address_id = a.address_id ORDER BY a.address_city";
    PreparedStatement pstmt = con.prepareStatement(sql);
    ResultSet rst = pstmt.executeQuery();

    List<VendorsByCityDto> vendorByCityList = new ArrayList<>();

    while (rst.next()) {
        int vendorId = rst.getInt("vendor_id");
        String vendorFirstName = rst.getString("vendor_first_name");
        String vendorLastName = rst.getString("vendor_last_name");
        String vendorEmail = rst.getString("vendor_email");
        String vendorPhoneNumber = rst.getString("vendor_phone_number");
        String vendorRegistrationDate = rst.getString("vendor_registration_date");
        String city=rst.getString("address_city");
        VendorsByCityDto vendorByCity = new VendorsByCityDto(vendorId, vendorFirstName, vendorLastName, 
                                                             vendorEmail, vendorPhoneNumber, vendorRegistrationDate,city);
        vendorByCityList.add(vendorByCity);
    }

    DBConnection.dbClose();
    return vendorByCityList;
}

}