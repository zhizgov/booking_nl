package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.controller.ResponseTopDestinations;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.domain.Visit;
import com.example.bookingnl.exceptions.DuplicationException;
import com.example.bookingnl.exceptions.InvalidData;
import com.example.bookingnl.exceptions.UnauthorizedException;
import com.example.bookingnl.persistence.DestinationRepository;
import com.example.bookingnl.persistence.UserRepository;
import com.example.bookingnl.persistence.VisitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository repository;
    private final VisitRepository visitRepository;


    @Override
    public List<Destination> findAll() {
        return repository.findAll();
    }

    @Override
    public Destination saveDestination(Destination destination) throws DuplicationException {

        if (repository.findByNameAndLocation(destination.getName(), destination.getLocation()).isEmpty()) {

            return repository.save(destination);
        }
        throw new DuplicationException();
    }

    @Override
    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public List<ResponseTopDestinations> getTopFiveDestinations(Date startDate, Date endDate, int limit) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return visitRepository.findTopFiveDestinations( limit)
                .stream()
                .map(result -> {
                        return new ResponseTopDestinations(
                                Long.parseLong(result[0].toString()),
                                Integer.parseInt(result[1].toString()));
                })
                .collect(Collectors.toList());

    }


    @Override
    public Optional<Destination> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteDestinationById(Long id) throws Exception {
//
        if (repository.findById(id) != null) {
            repository.deleteDestinationById(id);
        } else {
            throw new Exception("You have not selected a destination to be deleted!");
        }
    }
}
