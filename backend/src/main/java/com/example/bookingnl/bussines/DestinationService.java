package com.example.bookingnl.bussines;

import com.example.bookingnl.controller.ResponseTopDestinations;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.Visit;
import com.example.bookingnl.exceptions.DuplicationException;
import com.example.bookingnl.exceptions.UnauthorizedException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Destination saveDestination(Destination destination) throws DuplicationException;

    Visit saveVisit(Visit visit);

    List<ResponseTopDestinations> getTopFiveDestinations(Date startDate, Date endDate, int limit);

    Optional<Destination> findById(Long id);

    void deleteDestinationById(Long id) throws Exception;

    List<Destination> findAll();
}
