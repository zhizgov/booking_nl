package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.ReservationService;
import com.example.bookingnl.domain.Reservation;
import com.example.bookingnl.persistence.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> findAllReservationsByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
