//Author : Anand Karthick

package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ReservationPerCity;
import com.dto.RevenuePerCity;
import com.dto.VendorsByCityDto;
import com.exception.DatabaseConnectionException;

public interface ReservationPerCityDao {

	List<ReservationPerCity> getReservationCountPerCity() throws SQLException, DatabaseConnectionException;

	List<RevenuePerCity> getRevenuePerCity() throws SQLException, DatabaseConnectionException;

	List<VendorsByCityDto> getVendorsByCity() throws SQLException, DatabaseConnectionException;

}
