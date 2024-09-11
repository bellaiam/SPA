package com.tbb.krazyolives.services;

import com.tbb.krazyolives.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getReservationByEmail() {
        Reservation reservation = new Reservation();
        assertNull(reservation.getResEmail());
    }

    @Test
    void getReservationById() {
        Reservation reservation = new Reservation("Bella","Aminov", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "baminov@gmail.com", "8", "massage for 4");
        assertNotNull(reservation.getId());
    }
}
//package com.tbb.krazyolives;
//
//import com.tbb.krazyolives.controllers.UserController;
//import com.tbb.krazyolives.models.User;
//import com.tbb.krazyolives.services.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import static org.hamcrest.Matchers.any;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyList;
////import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(Parameterized.class)
//public class UserControllerTest {
//
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private Model model;
//
//    @Mock
//    private User user;
//
//    private String expectedViewName;
//    private String requestMapping;
////
////    @Before
////    public void setUp() {
////        MockitoAnnotations.initMocks(this);
////        userController = new UserController(userService);
////    }
////
////    public UserControllerTest(String expectedViewName, String requestMapping) {
////        this.expectedViewName = expectedViewName;
////        this.requestMapping = requestMapping;
////    }
////
////    @Parameterized.Parameters(name = "{index}: expectedViewName={0}, requestMapping={1}")
////    public static Iterable<Object[]> data() {
////        return Arrays.asList(new Object[][]{
////                {"user", "/users/listUsers"},
////                {"new-user", "/users/showNewUserForm"},
////                {"update-user", "/users/showFormForUpdate/1"}
////        });
////    }
////
////    @Test
////    public void testViewUsersPage() {
////        when(userService.getAllUsers()).thenReturn(Collections.emptyList());
////
////        String actualViewName = userController.viewUsersPage(model);
////
////        assertEquals(expectedViewName, actualViewName);
////        verify(model).addAttribute(eq("listUsers"), anyList());
////    }
////
////    @Test
////    public void testShowNewUserForm() {
////        String actualViewName = userController.showNewUserForm(model);
////
////        assertEquals(expectedViewName, actualViewName);
////        verify(model).addAttribute(eq("user"), any(User.class));
////    }
////
////    @Test
////    public void testShowFormForUpdate() {
////        long userId = 1L;
////        when(userService.getUserById(userId)).thenReturn(user);
////
////        String actualViewName = userController.showFormForUpdate(userId, model);
////
////        assertEquals(expectedViewName, actualViewName);
////        verify(model).addAttribute(eq("user"), eq(user));
////    }
//}
