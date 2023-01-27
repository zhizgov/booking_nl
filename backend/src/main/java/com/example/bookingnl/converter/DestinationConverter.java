package com.example.bookingnl.converter;

import com.example.bookingnl.controller.CreateDestinationRequest;
import com.example.bookingnl.controller.VisitRequest;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.controller.DestinationResponse;
import com.example.bookingnl.domain.Visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DestinationConverter {

    public static Destination requestToEntity(CreateDestinationRequest request){
        Destination destination = Destination.builder()
                .name(request.getName())
                .location(request.getLocation())
                .imageURL(request.getImageURL())
                .pricePerNight(request.getPricePerNight())
                .build();
        return destination;
    }
    public static Date stringToDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public static Visit requestToEntity(VisitRequest request) throws ParseException {
        Visit visit = Visit.builder()
                .destinationId(request.getDestinationId())
                .dateOfVisit(stringToDate(request.getDateOfVisit()))
                .build();
        return visit;
    }
    public static DestinationResponse entityToResponse(Destination destination){
        DestinationResponse response = DestinationResponse.builder()
                .id(destination.getId())
                .build();
        return response;
    }
}
