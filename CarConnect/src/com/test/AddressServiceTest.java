package com.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.exception.*;
import com.model.*;
import com.service.*;
import com.dao.*;
import com.dto.*;
import com.utility.*;
import com.controller.*;

public class AddressServiceTest {
	AddressService addressService=new AddressService();
   
	  

    @Test
    public void testGetReservationCountPerCity() throws SQLException, DatabaseConnectionException, ResourceNotFoundException {
        
        ReservationPerCity city1 = new ReservationPerCity("salem", 2);
        ReservationPerCity city2 = new ReservationPerCity("New Delhi", 2);
        ReservationPerCity city3 = new ReservationPerCity("Kolkata", 2);
        ReservationPerCity city4 = new ReservationPerCity("Indore", 2);
        ReservationPerCity city5 = new ReservationPerCity("Patna", 2);
        ReservationPerCity city6 = new ReservationPerCity("Chandigarh", 2);
        ReservationPerCity city7 = new ReservationPerCity("", 1); // Corrected count to 2
        ReservationPerCity city8 = new ReservationPerCity("bhopal", 1);
        ReservationPerCity city9 = new ReservationPerCity("cb", 1);
        ReservationPerCity city10 = new ReservationPerCity("kochi", 1);
        
        /*salem: 2
New Delhi: 2
Kolkata: 2
Indore: 2
Patna: 2
Chandigarh: 2
: 1
bhopal: 1
cb: 1
Kochi: 1*/
        
        List<ReservationPerCity> expected = Arrays.asList(city1, city2, city3, city4, city5, city6, city7, city8, city9, city10);

        try { 
            List<ReservationPerCity> actual = addressService.getReservationPerCity();

            Assert.assertEquals(expected.size(), actual.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
                Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
            }
        } catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       
        // use case 2
        expected = Arrays.asList(city2, city3, city4, city5, city6, city7, city8, city9, city10);

        try { 
            List<ReservationPerCity> actual = addressService.getReservationPerCity();
            actual.remove(0);
            
            Assert.assertEquals(expected.size(), actual.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
                Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
            }
        } catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       
        // use case 3
        expected = Arrays.asList(city1, city2, city3, city4, city5, city6, city7, city8, city9);

        try { 
            List<ReservationPerCity> actual = addressService.getReservationPerCity();
            actual.remove(actual.size() - 1);
            
            Assert.assertEquals(expected.size(), actual.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
                Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
            }
        } catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       
        // use case 4
        expected = Arrays.asList(city2, city3, city4, city5, city6, city7, city8, city9);

        try { 
            List<ReservationPerCity> actual = addressService.getReservationPerCity();
            actual.remove(0);
            actual.remove(actual.size() - 1);
            
            Assert.assertEquals(expected.size(), actual.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
                Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
            }
        } catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }
    
    @Test
    public void testGetRevenuePerCity() throws SQLException, DatabaseConnectionException {
    
        RevenuePerCity city1 = new RevenuePerCity("Kolkata", 17600.0);
        RevenuePerCity city2 = new RevenuePerCity("salem", 14000.0);
        RevenuePerCity city3 = new RevenuePerCity("New Delhi", 9400.0);
        RevenuePerCity city4 = new RevenuePerCity("", 8800.0);
        RevenuePerCity city5 = new RevenuePerCity("Patna", 6300.0);
        RevenuePerCity city6 = new RevenuePerCity("Chandigarh", 5000.0);
        RevenuePerCity city7 = new RevenuePerCity("bhopal", 4800.0);
        RevenuePerCity city8 = new RevenuePerCity("Indore", 4400.0);
        RevenuePerCity city9 = new RevenuePerCity("Kochi", 3200.0);
        RevenuePerCity city10 = new RevenuePerCity("cb", 3000.0);

        List<RevenuePerCity> expected = Arrays.asList(city1, city2, city3, city4, city5, city6, city7, city8, city9, city10);

        try {
            List<RevenuePerCity> actual = addressService.getRevenuePerCity();
            Assert.assertEquals(expected.size(), actual.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
                Assert.assertEquals(expected.get(i).getTotalRevenue(), actual.get(i).getTotalRevenue(), 0.01);
            }
        } catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
