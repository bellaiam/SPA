package com.tbb.krazyolives.services;

import com.tbb.krazyolives.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserById() {
        User user = new User(999L, "Bella", "Aminov", "baminov@gmail.com", "password");
        assertEquals(999L, user.getId());


    }

@Test
    void getUserByWrongId() {
        User user = new User(756L, "Bella", "Aminov", "baminov@gmail.com", "password");
        assertNotEquals(765L, user.getId());
    }

    @Test
    void findByEmail() {
        User user = new User(756L, "Bella", "Aminov", "baminov@gmail.com", "password");
        assertEquals("baminov@gmail.com", user.getEmail());
    }


}