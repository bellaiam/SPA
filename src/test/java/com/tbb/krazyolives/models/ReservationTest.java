package com.tbb.krazyolives.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {


    @Test
    void getResFirstName() {
        Reservation reservation = new Reservation("Bella","Aminov", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "baminov@gmail.com", "4", "massage for 4");
        assertEquals("Bella", reservation.getResFirstName());
    }


    @Test
    void getResNoOfGuests() {
        Reservation reservation = new Reservation("Bella","Aminov", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "baminov@gmail.com", "8", "massage for 4");
        assertEquals("8", reservation.getResNoOfGuests());
    }


    @Test
    void getWrongResLastName(){
        Reservation reservation = new Reservation("Bella","Aminov", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "baminov@gmail.com", "8", "massage for 4");
        assertNotEquals("Johnson", reservation.getResLastName());

    };
}
//package com.tbb.krazyolives.data;
//
//
//
//
//import com.tbb.krazyolives.data.UserRepository;
//import com.tbb.krazyolives.models.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testFindByEmail() {
//        // Given
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Smith");
//        user.setEmail("john@example.com");
//        userRepository.save(user);
//
//        // When
//        User foundUser = userRepository.findByEmail("john@example.com");
//
//        // Then
//        assertThat(foundUser).isNotNull();
//        assertThat(foundUser.getFirstName()).isEqualTo("John");
//        assertThat(foundUser.getLastName()).isEqualTo("Smith");
//    }
//}
//
//
//
//
