package com.example.bookingnl.bussines.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.Reservation;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReservationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ReservationServiceImplTest {
    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    @Test
    void testSaveReservation() throws Exception {
//        Reservation reservation = new Reservation();
//
//        Destination destination = new Destination();
//        destination.setId(123L);
//        destination.setLocation("Location");
//        destination.setName("Name");
//        destination.setPricePerNight(10.0d);
//        reservation.setDestination(destination);
//        ZoneId zone = ZoneId.of("UTC");
//        reservation.setEndDate(Date.from(LocalDate.of(2024, 1, 10).atStartOfDay().atZone(zone).toInstant()));
//        reservation.setGuests(1);
//        reservation.setId(123L);
//        ZoneId zone1 = ZoneId.of("UTC");
//        reservation.setStartDate(Date.from(LocalDate.of(2024, 1, 1).atStartOfDay().atZone(zone1).toInstant()));
//        reservation.setTotalPrice(10.0d);
//
//        User user = new User();
//        user.setAdress("Adress");
//        user.setEmail("mail@example.org");
//        user.setFirstName("Ivan");
//        user.setId(123L);
//        user.setLastName("Ivan");
//        user.setPassword("1234");
//        user.setRole("Role");
//        reservation.setUser(user);
//        when(reservationServiceImpl.saveReservation(reservation)).thenReturn(reservation);

    }

    @Test
    void testSaveReservation2() throws Exception {

    }

    @Test
    void testFindAllReservationsByUserId() {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        when(reservationRepository.findAllByUserId((Long) any())).thenReturn(reservationList);
        List<Reservation> actualFindAllReservationsByUserIdResult = reservationServiceImpl
                .findAllReservationsByUserId(123L);
        assertSame(reservationList, actualFindAllReservationsByUserIdResult);
        assertTrue(actualFindAllReservationsByUserIdResult.isEmpty());
        verify(reservationRepository).findAllByUserId((Long) any());
    }
}

