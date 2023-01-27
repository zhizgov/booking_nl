package com.example.bookingnl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UpdateUserRequestTest {

    @Test
    void testConstructor() {
        //arrange
        UpdateUserRequest actualUpdateUserRequest = new UpdateUserRequest();
        //act
        actualUpdateUserRequest.setAdress("Adress");
        actualUpdateUserRequest.setEmail("joe@example.org");
        actualUpdateUserRequest.setFirstName("jo");
        actualUpdateUserRequest.setLastName("do");
        String actualToStringResult = actualUpdateUserRequest.toString();
        //assert
        assertEquals("Adress", actualUpdateUserRequest.getAdress());
        assertEquals("joe@example.org", actualUpdateUserRequest.getEmail());
        assertEquals("jo", actualUpdateUserRequest.getFirstName());
        assertEquals("do", actualUpdateUserRequest.getLastName());
        assertEquals("UpdateUserRequest(email=joe@example.org, firstName=jo, lastName=do, adress=Adress)",
                actualToStringResult);
    }




}

