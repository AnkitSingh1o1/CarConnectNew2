/*Author :AKSHAY PAWAR*/

package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.ReviewDao;
import com.dao.ReviewDaoImpl;
import com.dto.ReviewDto;
import com.exception.InvalidInputException;
import com.exception.VehicleNotFoundException;
import com.model.Review;
import com.utility.AscSortOfReviewByRating;
import com.utility.DescSortOfReviewByRating;

public class ReviewService {
   ReviewDao dao=new ReviewDaoImpl();
	public int add(Review review) throws SQLException {
		return dao.add(review);
		
	}
	
	public List<Review> DisplayAll() throws SQLException {
	
		return dao.findAll();
	}

	public void deleteByid(int nextInt) throws SQLException, InvalidInputException {
		boolean isIdValid = dao.findOne(nextInt);
		if(!isIdValid)
			throw new InvalidInputException("Invalid Customer Id!");
		 
		dao.deleteById(nextInt);
		
		
	}

	public List<Review> getReviewsByVendorId(int vendor_id) throws SQLException, InvalidInputException {
		boolean isvendor_idValid = dao.findVendor(vendor_id);
		if(!isvendor_idValid)
			throw new InvalidInputException("Invalid Vendor Id");
	
          return dao.getReviewsByVendorId(vendor_id);
		
	}

	public List<Review> getReviewsByVehicleId(int vehicle_id) throws SQLException, VehicleNotFoundException{
		boolean isvendor_idValid = dao.findVehicle(vehicle_id);
		if(!isvendor_idValid)
			throw new VehicleNotFoundException("Invalid Vehicle Id");
	
          return dao.getReviewsByVehicleId(vehicle_id);
	}

	public List<ReviewDto> getReviewStats() throws SQLException {
		return dao.getReviewStats();
	}



public List<Review> sortReviewByRating(List<Review> list, String sortDirection){
	 
	if(sortDirection.equalsIgnoreCase("ASC")) {
		Collections.sort(list,new AscSortOfReviewByRating());
	}
	else
	if(sortDirection.equalsIgnoreCase("DESC")) {
		Collections.sort(list,new DescSortOfReviewByRating());
	}
	return list;
}
	
}






