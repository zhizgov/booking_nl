package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.converter.DestinationConverter;
import com.example.bookingnl.domain.*;
import com.example.bookingnl.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.DateFormatter;
import javax.transaction.Transactional;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinations")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@Transactional
public class DestinationController {
    private final DestinationService service;


    @GetMapping()
    public ResponseEntity<List<Destination>> getDestinations() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<DestinationResponse> saveDestination(@RequestBody CreateDestinationRequest request) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/destinations").toUriString());
        Destination destination = DestinationConverter.requestToEntity(request);
        DestinationResponse response = DestinationConverter.entityToResponse(service.saveDestination(destination));
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/visit")
    public ResponseEntity<Visit> saveVisit(@RequestBody VisitRequest visit) throws ParseException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/destinations/visit").toUriString());
        Visit actual = DestinationConverter.requestToEntity(visit);


        return ResponseEntity.created(uri).body(service.saveVisit(actual));
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<ResponseTopDestinations>> getTopFiveVisits() throws ParseException {
        int limit = 5;
        String startDate = "2023-01-11";
        String endDate = "2023-02-11";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);


        return ResponseEntity.ok().body(service.getTopFiveDestinations(start, end, limit));
    }

    @GetMapping("{id}")
    public Optional<Destination> getDestination(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id)).getBody();

    }

    @DeleteMapping("{id}")
    public String deleteDestination(@PathVariable("id") Long id) {
        try {
            service.deleteDestinationById(id);
            return "Successful deletion";
        } catch (UnauthorizedException e) {
            return e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
