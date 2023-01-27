package com.example.bookingnl.controller;

import com.example.bookingnl.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseTopDestinations {
    private Long visit;
    private Integer count;
}
