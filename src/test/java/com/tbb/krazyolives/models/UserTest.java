package com.tbb.krazyolives.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void getEmail() {
        User user = new User("Lana", "Boulton", "lboulton@gmail.com", "password");
        assertEquals("lboulton@gmail.com", user.getEmail());
    }

    @Test
    void getPassword() {
    }

    @Test
    void getReservations() {
    }
}