package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.bookingnl.exceptions.InvalidData;
import org.junit.jupiter.api.Test;

class DestinationTest {
    //happy flow
    @Test
    void destinationTestConstructor() throws InvalidData {
        //arrange
        Destination actualDestination = new Destination();
        //act
        actualDestination.setName("Pakistan");
        actualDestination.setLocation("Pakistan1");
        actualDestination.setId(123L);
        actualDestination.setPricePerNight(10.0d);
        //assert
        assertEquals("Pakistan", actualDestination.getName());
        assertEquals("Pakistan1", actualDestination.getLocation());
        assertEquals(123L, actualDestination.getId().longValue());
        assertEquals(10.0d, actualDestination.getPricePerNight());
    }

    //happy flow
    @Test
    void testSetPricePerNight() throws InvalidData {
        //arrange
        Destination destination = new Destination();
        //act
        destination.setPricePerNight(10.0d);
        //assert
        assertEquals(10.0d, destination.getPricePerNight());
    }

    //unhappy flow
    @Test
    void testSetPricePerNight_when_price_is_zero() throws InvalidData {
        assertThrows(InvalidData.class, () -> (new Destination()).setPricePerNight(0.0d));
    }
}

