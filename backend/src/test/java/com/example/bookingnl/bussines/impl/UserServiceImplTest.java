package com.example.bookingnl.bussines.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.exceptions.DuplicationException;
import com.example.bookingnl.exceptions.InvalidData;
import com.example.bookingnl.persistence.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("ra6ko@example.org");
        user.setFirstName("Rado");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("1234");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("ra6ko@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("1234", actualLoadUserByUsernameResult.getPassword());
        verify(userRepository).findByEmail((String) any());
    }


    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getEmail()).thenThrow(new UsernameNotFoundException("User with email {} found"));
        when(user.getPassword()).thenThrow(new UsernameNotFoundException("User with email {} found"));
        when(user.getRole()).thenReturn("Role");
        doNothing().when(user).setAdress((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((String) any());
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByEmail((String) any());
        verify(user).getEmail();
        verify(user).getRole();
        verify(user).setAdress((String) any());
        verify(user).setEmail((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setId((Long) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((String) any());
    }


    //happy flow
    @Test
    void testFindByEmail() {
        //arrange
        User user = new User();
        //act
        user.setAdress("street");
        user.setEmail("go4o@example.org");
        user.setFirstName("Go4o");
        user.setId(123L);
        user.setLastName("Ivo");
        user.setPassword("1234");
        user.setRole("Role");
        when(userRepository.findUserByEmail((String) any())).thenReturn(user);
        //assert
        assertSame(user, userServiceImpl.findByEmail("go4o@example.org"));
        verify(userRepository).findUserByEmail((String) any());
    }

    //unhappy flow
    @Test
    void testFindByEmail_notExisting() {
        when(userRepository.findUserByEmail((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findByEmail("go4o@example.org"));
        verify(userRepository).findUserByEmail((String) any());
    }

    //happy flow
    @Test
    void testFindById() {
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        when(userRepository.findUserById((Long) any())).thenReturn(user);
        assertSame(user, userServiceImpl.findById(123L));
        verify(userRepository).findUserById((Long) any());
    }

    //unhappy flow
    @Test
    void testFindById_notExisting() {
        when(userRepository.findUserById((Long) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.findById(123L));
        verify(userRepository).findUserById((Long) any());
    }

    //happy flow
    @Test
    void testSave() {
        //arrange
        User user = new User();
        //act
        user.setAdress("Adress");
        user.setEmail("koko@example.org");
        user.setFirstName("Koko");
        user.setId(123L);
        user.setLastName("Dobrev");
        user.setPassword("1234");
        user.setRole("Role");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.save((User) any())).thenReturn(user);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        User user1 = new User();
        user1.setAdress("Adress");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        //assert
        assertSame(user, userServiceImpl.save(user1));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).save((User) any());
        verify(passwordEncoder).encode((CharSequence) any());
        assertEquals("secret", user1.getPassword());
    }

    //unhappy flow
    @Test
    void testSave_unsuccessfully_withAlreadyExistingEmail() throws DuplicationException {
        //arrange

        User user1 = new User();
        when(userRepository.existsByEmail((String) any())).thenThrow(DuplicationException.class);

        //assert
        assertThrows(DuplicationException.class, () -> userServiceImpl.save(user1));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository, never()).save((User) any());
        verify(passwordEncoder, never()).encode((CharSequence) any());
    }


}

