package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Address;

public interface AddressDao {
	int save(Address address) throws SQLException;
	boolean findOne(int address_id) throws SQLException;
	/*void DeleteById(int address_id) throws SQLException;*/
	List<Address> findAll() throws SQLException;
	int softDeleteById(int address_id) throws SQLException;
	int updateById(Address address) throws SQLException;
	
}
