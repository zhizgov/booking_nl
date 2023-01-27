package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    List<Reservation> findAllReservationsByUserId(Long userId);
}
