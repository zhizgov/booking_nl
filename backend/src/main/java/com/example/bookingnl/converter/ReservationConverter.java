package com.example.bookingnl.converter;

import com.example.bookingnl.controller.CreateReservationRequest;
import com.example.bookingnl.controller.ReservationResponse;
import com.example.bookingnl.domain.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReservationConverter {
    private String convert(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static Reservation requestToEntity(CreateReservationRequest request){
        Reservation reservation = Reservation.builder()
                .user(request.getUser())
                .destination(request.getDestination())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .guests(request.getGuests())
                .totalPrice(request.getTotalPrice())
                .build();
        return reservation;
    }

    public static ReservationResponse entityToResponse(Reservation reservation){
        ReservationResponse response = ReservationResponse.builder()
                .id(reservation.getId())
                .build();
        return response;
    }
}
