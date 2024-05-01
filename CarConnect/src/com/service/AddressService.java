package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.AddressDao;
import com.dao.AddressDaoImpl;
import com.exception.DatabaseConnectionException;
import com.exception.ResourceNotFoundException;
import com.model.Address;

public class AddressService {

	AddressDao addressDao = new AddressDaoImpl();

	public int save(Address address) throws SQLException, DatabaseConnectionException {
		return addressDao.save(address);
	}

	public List<Address> findAll() throws SQLException, DatabaseConnectionException {
		return addressDao.findAll();
	}

	public int softDeleteAddress(int addressId)
			throws SQLException, ResourceNotFoundException, DatabaseConnectionException {
		boolean isAddressIdValid = addressDao.findOne(addressId);
		if (!isAddressIdValid)
			throw new ResourceNotFoundException("Address ID is invalid");
		addressDao.softDeleteById(addressId);
		return 1; // Assuming 1 means success
	}

	public int updateById(Address address) throws SQLException, ResourceNotFoundException, DatabaseConnectionException {
		boolean isAddressIdValid = addressDao.findOne(address.getAddress_id());
		if (!isAddressIdValid)
			throw new ResourceNotFoundException("Address ID is invalid");
		return addressDao.updateById(address);
	}
}
