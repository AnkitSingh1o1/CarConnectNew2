/*Author :AKSHAY PAWAR*/

package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.VehicleDto;
import com.exception.InvalidInputException;
import com.exception.VehicleNotFoundException;
import com.model.Vehicle;

public interface VehicleDao {
     int addVehicle(Vehicle vehicle) throws SQLException;
     List<Vehicle> findAll() throws SQLException;
     void deleteById(int vehicleId) throws SQLException,VehicleNotFoundException;
     Boolean findOne(int vehicleId) throws SQLException; 
     //void softDeleteById(int id) throws SQLException,InvalidInputException;
     List<VehicleDto> getVehicleStats() throws SQLException;
     List<Vehicle> findAllAvailable() throws SQLException;
     List<Vehicle> findMyVehicles(int vendorId) throws SQLException;
     double getDailyRate(int vehicleId)throws SQLException,VehicleNotFoundException;
     int getVehicleYear(int vehicleId)throws SQLException,VehicleNotFoundException;
}
