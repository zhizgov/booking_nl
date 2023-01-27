package com.example.bookingnl.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitRequest{
        private Long destinationId;
        private String dateOfVisit;
}
