package com.service;

import java.sql.SQLException;

import java.util.List;

import com.dao.AddressDao;
import com.dao.*;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.dto.*;
import com.dao.ReservationPerCityDao;
import com.dao.ReservationPerCityDaoImpl;
import com.exception.DatabaseConnectionException;
import com.exception.ResourceNotFoundException;
import com.exception.*;
import com.model.*;

public class AddressService {

    AddressDao addressDao = new AddressDaoImpl();
    UserDao userDao = new UserDaoImpl();
    ReservationPerCityDao reservationPerCityDao = new ReservationPerCityDaoImpl();
 
    private boolean isValidAddress(Address address) throws SQLException, DatabaseConnectionException{
        if(address==null|| !addressDao.isCityStateValid(address.getAddress_city(), address.getAddress_state())) {
            return false;
        }
        else if (address.getAddress_pincode()==null || address.getAddress_pincode().length()!=6 || address.getAddress_pincode().charAt(0)=='0') {
            return false;
        }
        
        return true;
    }

    public int save(Address address) throws SQLException, DatabaseConnectionException, AddressInvalidException {
        if (!isValidAddress(address)) {
            throw new AddressInvalidException("Invalid address! Enter a Valid Indian address " + address.toString());
        }
        return addressDao.save(address);
    }

    public List<Address> findAll() throws SQLException, DatabaseConnectionException {
        return addressDao.findAll();
    }

    public int softDeleteAddress(int addressId) throws SQLException, ResourceNotFoundException, DatabaseConnectionException {
        boolean isAddressIdValid = addressDao.findOne(addressId);
        if (!isAddressIdValid)
            throw new ResourceNotFoundException("Address ID is invalid");
        addressDao.softDeleteById(addressId);
        return 1; 
    }

    public int updateById(Address address) throws SQLException, ResourceNotFoundException, DatabaseConnectionException, AddressInvalidException {
        if (!isValidAddress(address)) {
            throw new AddressInvalidException("Invalid address: " + address.toString());
        }
        boolean isAddressIdValid = addressDao.findOne(address.getAddress_id());
        if (!isAddressIdValid)
            throw new ResourceNotFoundException("Address ID is invalid");
        return addressDao.updateById(address);
    }
    
    public int getAddressIdByUserId(int Id) throws SQLException, ResourceNotFoundException, DatabaseConnectionException, AddressInvalidException {
        boolean isUserIdValid=userDao.findOne(Id);
        if(!isUserIdValid)
            throw new ResourceNotFoundException("User ID is invalid");
        int address_id=addressDao.getAddressIdByUserId(Id);
        if (address_id==0) {
            throw new AddressInvalidException("Address ID not found");
        }
        return address_id;
    }
    
    public List<ReservationPerCity>getReservationPerCity() throws SQLException, DatabaseConnectionException{
        return reservationPerCityDao.getReservationCountPerCity();
    }
    
    public List<RevenuePerCity>getRevenuePerCity() throws SQLException, DatabaseConnectionException{
        return reservationPerCityDao.getRevenuePerCity();
    }
    
    public List<VendorsByCityDto> getVendorsByCity() throws SQLException, DatabaseConnectionException {
        return reservationPerCityDao.getVendorsByCity();
    }
    
}
