package com.example.bookingnl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserResponseTest {
  
    @Test
    void testConstructor() {
        UserResponse actualUserResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        actualUserResponse.setAdress("Adress");
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setFirstName("Jane");
        actualUserResponse.setId(123L);
        actualUserResponse.setLastName("Doe");
        String actualToStringResult = actualUserResponse.toString();
        assertEquals("Adress", actualUserResponse.getAdress());
        assertEquals("jane.doe@example.org", actualUserResponse.getEmail());
        assertEquals("Jane", actualUserResponse.getFirstName());
        assertEquals(123L, actualUserResponse.getId().longValue());
        assertEquals("Doe", actualUserResponse.getLastName());
        assertEquals("UserResponse(id=123, firstName=Jane, lastName=Doe, email=jane.doe@example.org, adress=Adress)",
                actualToStringResult);
    }


}

