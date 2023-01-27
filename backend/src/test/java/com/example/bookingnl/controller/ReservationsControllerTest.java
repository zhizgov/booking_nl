package com.example.bookingnl.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.bookingnl.bussines.ReservationService;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.Reservation;
import com.example.bookingnl.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ReservationsController.class})
@ExtendWith(SpringExtension.class)
class ReservationsControllerTest {
    @MockBean
    private ReservationService reservationService;

    @Autowired
    private ReservationsController reservationsController;

    //happy flow
    @Test
    void testGetDestinations_shouldReturnFullList() throws Exception {
//        //arrange
//        List<Reservation> reservations = new ArrayList<>(List.of(Reservation.builder().id(1L).totalPrice(10d).guests(1).endDate(2202-01-01).build()));
//        when(reservationService.findAllReservationsByUserId(any(Long.class))).thenReturn(reservations);
//
//        //act
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reservations");
//        String content = (new ObjectMapper()).writeValueAsString(reservations);
//        MockMvcBuilders.standaloneSetup(reservationsController)
//                .build()
//                .perform(requestBuilder)
//                //assert
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string(content));
    }

    //unhappy flow
    @Test
    void testGetDestination_emptyList() throws Exception {
//        //arrange
//        when(reservationService.findAllReservationsByUserId((Long) any())).thenReturn(new ArrayList<>());
//        //act
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/reservations");
//        MockHttpServletRequestBuilder requestBuilder = getResult.param("userId", String.valueOf(1L));
//        //assert
//        MockMvcBuilders.standaloneSetup(reservationsController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


//    @Test
//    void testSaveReservation() throws Exception {
//        //arrange
//        Destination destination = new Destination();
//        destination.setId(123L);
//        destination.setLocation("Location");
//        destination.setName("Name");
//        destination.setPricePerNight(10.0d);
//
//        User user = new User();
//        user.setAdress("Adress");
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(123L);
//        user.setLastName("Doe");
//        user.setPassword("iloveyou");
//        user.setRole("Role");
//
//        CreateReservationRequest createReservationRequest = new CreateReservationRequest();
//        createReservationRequest.setDestination(destination);
//        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
//        createReservationRequest.setEndDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
//        createReservationRequest.setGuests(1);
//        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
//        createReservationRequest.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
//        createReservationRequest.setTotalPrice(10.0d);
//        createReservationRequest.setUser(user);
//        String content = (new ObjectMapper()).writeValueAsString(createReservationRequest);
//        //act
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reservations")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        //assert
//        MockMvcBuilders.standaloneSetup(reservationsController)
//                .build()
//                .perform(requestBuilder)
//        .andExpect(MockMvcResultMatchers.status().is(400));
//    }

//
//    @Test
//    void testSaveReservation2() throws Exception {
//        //arrange
//        Destination destination = new Destination();
//        destination.setId(123L);
//        destination.setLocation("Location");
//        destination.setName("Name");
//        destination.setPricePerNight(10.0d);
//        java.sql.Date date = mock(java.sql.Date.class);
//        when(date.getTime()).thenReturn(10L);
//
//        User user = new User();
//        user.setAdress("Adress");
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setId(123L);
//        user.setLastName("Doe");
//        user.setPassword("iloveyou");
//        user.setRole("Role");
//
//        CreateReservationRequest createReservationRequest = new CreateReservationRequest();
//        createReservationRequest.setDestination(destination);
//        createReservationRequest.setEndDate(date);
//        createReservationRequest.setGuests(1);
//        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
//        createReservationRequest
//                .setStartDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
//        createReservationRequest.setTotalPrice(10.0d);
//        createReservationRequest.setUser(user);
//        String content = (new ObjectMapper()).writeValueAsString(createReservationRequest);
//        //act
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reservations")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        //assert
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(reservationsController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
//    }
}

