package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.bussines.ReservationService;
import com.example.bookingnl.converter.ReservationConverter;
import com.example.bookingnl.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@Transactional
public class ReservationsController {
    private ReservationService service;

    @PostMapping ("/private")
    public ResponseEntity<List<Reservation>> getDestinations(@RequestParam Long userId) {
        return ResponseEntity.ok().body(service.findAllReservationsByUserId(userId));
    }

    @PostMapping()
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody CreateReservationRequest request) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/reservations").toUriString());
        Reservation reservation = ReservationConverter.requestToEntity(request);
        ReservationResponse response = ReservationConverter.entityToResponse(service.saveReservation(reservation));
        return ResponseEntity.created(uri).body(response);
    }
}
