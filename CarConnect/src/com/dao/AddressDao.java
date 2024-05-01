package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Address;

public interface AddressDao {
	int save(Address address) throws SQLException, DatabaseConnectionException;
	boolean findOne(int address_id) throws SQLException, DatabaseConnectionException;
	/*void DeleteById(int address_id) throws SQLException;*/
	List<Address> findAll() throws SQLException, DatabaseConnectionException;
	int softDeleteById(int address_id) throws SQLException, DatabaseConnectionException;
	int updateById(Address address) throws SQLException, DatabaseConnectionException;
	
}
