package com.example.bookingnl.bussines.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.persistence.DestinationRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class DestinationServiceImplTest {
    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private DestinationServiceImpl destinationServiceImpl;


    @Test
    void testFindAll() {
        ArrayList<Destination> destinationList = new ArrayList<>();

        when(destinationRepository.findAll()).thenReturn(destinationList);
        List<Destination> actualFindAllResult = destinationServiceImpl.findAll();

        assertSame(destinationList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(destinationRepository).findAll();
    }


    @Test
    void testSaveDestination_unsuccessfully() throws Exception {
//        Destination destination = new Destination();
//        destination.setId(123L);
//        destination.setLocation("Location");
//        destination.setName("Name");
//        destination.setPricePerNight(10.0d);
//
//        Destination destination1 = new Destination();
//        destination1.setId(123L);
//        destination1.setLocation("Location");
//        destination1.setName("Name");
//        destination1.setPricePerNight(10.0d);
//        Optional<Destination> ofResult = Optional.of(destination1);
//        when(destinationRepository.save((Destination) any())).thenReturn(destination);
//        when(destinationRepository.findByNameAndLocation((String) any(), (String) any())).thenReturn(ofResult);
//
//        Destination destination2 = new Destination();
//        destination2.setId(123L);
//        destination2.setLocation("Location");
//        destination2.setName("Name");
//        destination2.setPricePerNight(10.0d);
//        assertNull(destinationServiceImpl.saveDestination(destination2));
//        verify(destinationRepository).findByNameAndLocation((String) any(), (String) any());
    }


    @Test
    void testSaveDestination_successfully() throws Exception {
        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);
        when(destinationRepository.save((Destination) any())).thenReturn(destination);
        when(destinationRepository.findByNameAndLocation((String) any(), (String) any())).thenReturn(Optional.empty());

        Destination destination1 = new Destination();
        destination1.setId(123L);
        destination1.setLocation("Location");
        destination1.setName("Name");
        destination1.setPricePerNight(10.0d);
        assertSame(destination, destinationServiceImpl.saveDestination(destination1));
        verify(destinationRepository).save((Destination) any());
        verify(destinationRepository).findByNameAndLocation((String) any(), (String) any());
    }


    @Test
    void testFindById() throws Exception {
        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);
        Optional<Destination> ofResult = Optional.of(destination);
        when(destinationRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Destination> actualFindByIdResult = destinationServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(destinationRepository).findById((Long) any());
    }

    @Test
    void testFindById_return_null() throws Exception {
        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);
        Optional<Destination> ofResult = Optional.of(destination);
        when(destinationRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Destination> actualFindByIdResult = destinationServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(destinationRepository).findById((Long) any());
    }


    @Test
    void testDeleteDestinationById() throws Exception {
        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);
        Optional<Destination> ofResult = Optional.of(destination);
        when(destinationRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(destinationRepository).deleteDestinationById((Long) any());
        destinationServiceImpl.deleteDestinationById(123L);
        verify(destinationRepository).findById((Long) any());
        verify(destinationRepository).deleteDestinationById((Long) any());
    }




}

