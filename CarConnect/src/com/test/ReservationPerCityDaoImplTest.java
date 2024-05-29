package com.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.exception.*;
import com.dao.ReservationPerCityDaoImpl;
import com.dto.ReservationPerCity;
import com.exception.DatabaseConnectionException;

public class ReservationPerCityDaoImplTest {
    private ReservationPerCityDaoImpl reservationPerCityDao = new ReservationPerCityDaoImpl();

    @Test
    public void testGetReservationCountPerCity() throws SQLException, DatabaseConnectionException, ResourceNotFoundException {
        
        ReservationPerCity city1 = new ReservationPerCity("New Delhi", 2);
        ReservationPerCity city2 = new ReservationPerCity("Kolkata", 2);
        ReservationPerCity city3 = new ReservationPerCity("Indore", 2);
        ReservationPerCity city4 = new ReservationPerCity("Patna", 2);
        ReservationPerCity city5 = new ReservationPerCity("Chandigarh", 2);
        ReservationPerCity city6 = new ReservationPerCity("", 1);
        ReservationPerCity city7 = new ReservationPerCity("salem", 1);
        ReservationPerCity city8 = new ReservationPerCity("bhopal", 1);
        ReservationPerCity city9 = new ReservationPerCity("cb", 1);
        ReservationPerCity city10 = new ReservationPerCity("kochi", 1);
        
        List<ReservationPerCity> expected = Arrays.asList(city1, city2, city3, city4, city5, city6, city7, city8, city9, city10);

       try { List<ReservationPerCity> actual = reservationPerCityDao.getReservationCountPerCity();

        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
            Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
        }} catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       
       // use case 2
       expected = Arrays.asList(city2, city3, city4, city5, city6, city7, city8, city9, city10);
       

       try { List<ReservationPerCity> actual = reservationPerCityDao.getReservationCountPerCity();
       actual.remove(0);
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
            Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
        }} catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       
       // use case 3
   expected = Arrays.asList(city1,city2, city3, city4, city5, city6, city7, city8, city9);
       

       try { List<ReservationPerCity> actual = reservationPerCityDao.getReservationCountPerCity();
       actual.remove(actual.size()-1);
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
            Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
        }} catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
       

       // use case 4
   expected = Arrays.asList(city2, city3, city4, city5, city6, city7, city8, city9);
       

       try { List<ReservationPerCity> actual = reservationPerCityDao.getReservationCountPerCity();
       actual.remove(0);
       actual.remove(actual.size()-1);
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getCity().toLowerCase(), actual.get(i).getCity().toLowerCase());
            Assert.assertEquals(expected.get(i).getReservationCount(), actual.get(i).getReservationCount());
        }} catch (SQLException | DatabaseConnectionException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }
}
