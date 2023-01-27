package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingnl.exceptions.InvalidData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ReservationTest {

    @Test
    void reservationConstructor() throws Exception {

//        Destination actualDestination = new Destination();
//        actualDestination.setName("Pakistan");
//        actualDestination.setLocation("Pakistan1");
//        actualDestination.setId(123L);
//        actualDestination.setPricePerNight(10.0d);
//
//        User actualUser = new User();
//        actualUser.setAdress("Adress");
//        actualUser.setEmail("jane.doe@example.org");
//        actualUser.setFirstName("Jane");
//        actualUser.setId(123L);
//        actualUser.setLastName("Doe");
//        actualUser.setPassword("1234");
//        actualUser.setRole("Role");
//
//        Reservation actualReservation = new Reservation();
//        actualReservation.setDestination(actualDestination);
//        actualReservation.setGuests(2);
//        actualReservation.setUser(actualUser);
//        actualReservation.setId(123L);
//        actualReservation.setTotalPrice(100);
//        actualReservation.setStartDate(2201-1-1);
//        actualReservation.setEndDate(20-01-2001);
//        assertEquals(123L, actualReservation.getId().longValue());
    }

    //happy flow
    @Test
    void testSetStartDate() throws Exception {
//        //arrange
//        Reservation reservation = new Reservation();
//        java.sql.Date date = mock(java.sql.Date.class);
//        //act
//        when(date.compareTo((java.util.Date) any())).thenReturn(1);
//        reservation.setStartDate(date.toString());
//        //assert
//        verify(date).compareTo((java.util.Date) any());
    }
}

