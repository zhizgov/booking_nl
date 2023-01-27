package com.example.bookingnl.domain;

import com.example.bookingnl.converter.DestinationConverter;
import com.example.bookingnl.exceptions.InvalidData;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "destinationId", referencedColumnName = "id")
    private Destination destination;

    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
    @NotNull

    private int guests;

    private double totalPrice;


//    public void setEndDate(String endDateDate) throws Exception {
//        Date startD = DestinationConverter.stringToDate(startDate);
//        Date endD = DestinationConverter.stringToDate(endDateDate);
//        if (startD.compareTo(endD) <0){
//            this.endDate = endDateDate;
//        }
//        else{
//            throw new InvalidData();
//        }
//    }
}
