/*Author :AKSHAY PAWAR*/

package com.service;
import java.sql.SQLException;
import java.time.Year;
import java.util.Collections;
import java.util.List;

import com.dao.VehicleDao;
import com.dao.VehicleDaoImpl;
import com.dto.VehicleDto;
import com.exception.VehicleNotFoundException;
import com.model.Vehicle;
import com.utility.AscSortOfVehicleByDailyRate;
import com.utility.DescSortOfVehicleByDailyRate;


public class VehicleService {
	VehicleDao dao=new VehicleDaoImpl();
	public int add(Vehicle vehicle) throws SQLException {
		return dao.addVehicle(vehicle);
		
	}
	public List<Vehicle> DisplayAll() throws SQLException {
		return dao.findAll();
		
	}
	public void deleteByid(int id) throws  SQLException ,VehicleNotFoundException {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new VehicleNotFoundException("Id given is Invalid!!");
		 
		dao.deleteById(id);
		
	}
	public void softDeleteByid(int id) throws SQLException,VehicleNotFoundException  {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new VehicleNotFoundException("Id given is Invalid!!");
		 
		dao.softDeleteById(id);
		
	}
	public List<VehicleDto> getVehicleStats() throws SQLException {
		return dao.getVehicleStats();
	}
	public List<Vehicle> findAllAvailable() throws SQLException {
	
		return dao.findAllAvailable();
	}
	public List<Vehicle> findMyVehicles(int vendorId) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findMyVehicles(vendorId);
	}
	public double getDailyRate(int vehicleId) throws SQLException, VehicleNotFoundException {
		
		return dao.getDailyRate(vehicleId);
	}
	
	public int getVehicleAge(int vehicle_id) throws SQLException, VehicleNotFoundException{
	
		VehicleDaoImpl vehicleDaoImpl=new VehicleDaoImpl();
		 int currentYear = Year.now().getValue();
		int age=currentYear-vehicleDaoImpl.getVehicleYear(vehicle_id);
		if(age<0) {
			throw new VehicleNotFoundException("Vehicle Id is Invalid, Try Again!");
		}
		if(age>20) {
			throw new VehicleNotFoundException("Vehicle Id is Invalid, Try Again!");
		}
			
		return age;
		}

	public List<Vehicle> sortVehicleByDailyRate(List<Vehicle> list, String sortDirection){
		 
		if(sortDirection.equalsIgnoreCase("ASC")) {
			Collections.sort(list, new AscSortOfVehicleByDailyRate());
		}
		else
		if(sortDirection.equalsIgnoreCase("DESC")) {
			Collections.sort(list, new DescSortOfVehicleByDailyRate());
		}
		return list;
	}
	public int updateVehicleAvailability(Vehicle vehicle1) throws SQLException, VehicleNotFoundException {
		return dao.updateVehicleAvailability(vehicle1);
	}
	public int updateVehicleDailyRate(Vehicle vehicle12) throws SQLException, VehicleNotFoundException {
		return dao.updateVehicleDailyRate(vehicle12);
	}
		
}


	
