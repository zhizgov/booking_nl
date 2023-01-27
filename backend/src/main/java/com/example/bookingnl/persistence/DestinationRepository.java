package com.example.bookingnl.persistence;

import com.example.bookingnl.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination save(Destination destination);

    Optional<Destination> findByNameAndLocation(String name, String location);

    Optional<Destination> findById(Long id);

    void deleteDestinationById(Long id);

    List<Destination> findAll();
}
