package com.example.bookingnl.persistence;

import com.example.bookingnl.controller.ResponseTopDestinations;
import com.example.bookingnl.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query(value =
            "select visit.destination_id, COUNT(*) FROM visit " +

                    "GROUP BY destination_id  " +
                    "ORDER BY COUNT(*) " +
                    "DESC LIMIT :limit", nativeQuery = true)
    List<Object[]> findTopFiveDestinations( @Param("limit") int limit);
}
