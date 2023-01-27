package com.example.bookingnl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CreateUserRequestTest {


    @Test
    void testConstructor() {
        //arrange
        CreateUserRequest actualCreateUserRequest = new CreateUserRequest();
        //act
        actualCreateUserRequest.setAdress("Adress");
        actualCreateUserRequest.setEmail("jane.doe@example.org");
        actualCreateUserRequest.setFirstName("Jane");
        actualCreateUserRequest.setLastName("Doe");
        actualCreateUserRequest.setPassword("iloveyou");
        actualCreateUserRequest.setRole("Role");
        String actualToStringResult = actualCreateUserRequest.toString();
        //assert
        assertEquals("Adress", actualCreateUserRequest.getAdress());
        assertEquals("jane.doe@example.org", actualCreateUserRequest.getEmail());
        assertEquals("Jane", actualCreateUserRequest.getFirstName());
        assertEquals("Doe", actualCreateUserRequest.getLastName());
        assertEquals("iloveyou", actualCreateUserRequest.getPassword());
        assertEquals("Role", actualCreateUserRequest.getRole());
        assertEquals(
                "CreateUserRequest(firstName=Jane, lastName=Doe, email=jane.doe@example.org, adress=Adress, password=iloveyou,"
                        + " role=Role)",
                actualToStringResult);
    }


    @Test
    void testConstructor2() {
        CreateUserRequest actualCreateUserRequest = new CreateUserRequest("Jane", "Doe", "jane.doe@example.org", "Adress",
                "iloveyou", "Role");
        actualCreateUserRequest.setAdress("Adress");
        actualCreateUserRequest.setEmail("jane.doe@example.org");
        actualCreateUserRequest.setFirstName("Jane");
        actualCreateUserRequest.setLastName("Doe");
        actualCreateUserRequest.setPassword("iloveyou");
        actualCreateUserRequest.setRole("Role");
        String actualToStringResult = actualCreateUserRequest.toString();
        assertEquals("Adress", actualCreateUserRequest.getAdress());
        assertEquals("jane.doe@example.org", actualCreateUserRequest.getEmail());
        assertEquals("Jane", actualCreateUserRequest.getFirstName());
        assertEquals("Doe", actualCreateUserRequest.getLastName());
        assertEquals("iloveyou", actualCreateUserRequest.getPassword());
        assertEquals("Role", actualCreateUserRequest.getRole());
        assertEquals(
                "CreateUserRequest(firstName=Jane, lastName=Doe, email=jane.doe@example.org, adress=Adress, password=iloveyou,"
                        + " role=Role)",
                actualToStringResult);
    }

    @Test
    void testEquals() {
        assertNotEquals(new CreateUserRequest("Jane", "Doe", "jane.doe@example.org", "Adress", "iloveyou", "Role"), null);
        assertNotEquals(new CreateUserRequest("Jane", "Doe", "jane.doe@example.org", "Adress", "iloveyou", "Role"),
                "Different type to CreateUserRequest");
    }


}

