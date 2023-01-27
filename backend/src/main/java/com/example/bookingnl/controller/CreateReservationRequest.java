package com.example.bookingnl.controller;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateReservationRequest {
    private User user;
    private Destination destination;
    private String startDate;
    private String endDate;
    private int guests;
    private double totalPrice;

}
