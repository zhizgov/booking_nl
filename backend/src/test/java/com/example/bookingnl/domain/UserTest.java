package com.example.bookingnl.domain;

import com.example.bookingnl.controller.CreateUserRequest;
import com.example.bookingnl.exceptions.InvalidData;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    //happy flow
    @Test
    void userConstructor() {
        //arrange
        User actualUser = new User();
        //act
        actualUser.setAdress("Adress");
        actualUser.setEmail("jojo@example.org");
        actualUser.setFirstName("Jojo");
        actualUser.setId(123L);
        actualUser.setLastName("Az");
        actualUser.setPassword("1234");
        actualUser.setRole("Customer");
        //assert
        assertEquals("Adress", actualUser.getAdress());
        assertEquals("jojo@example.org", actualUser.getEmail());
        assertEquals("Jojo", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Az", actualUser.getLastName());
        assertEquals("1234", actualUser.getPassword());
        assertEquals("Customer", actualUser.getRole());
    }


}
