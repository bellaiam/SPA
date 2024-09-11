//package com.tbb.krazyolives.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//public class ReservationAuthorizationFilter extends GenericFilterBean {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String userId = authentication.getName(); // assuming that the user ID is stored in the authentication's name field
//            if (httpRequest.getRequestURI().startsWith("/auth/reservations")) {
//                // check if the requested reservation belongs to the user
//                String reservationId = httpRequest.getParameter("id");
//                if (reservationId != null) {
//                    // check if the reservation belongs to the user
//                    // you can retrieve the reservation using a service or repository and check if the user ID matches
//                    // if the reservation doesn't belong to the user, return a 403 error
//                    // otherwise, continue with the request chain
//                }
//            } else if (httpRequest.getRequestURI().startsWith("/auth/info-packages")) {
//                // check if the requested info package belongs to the user
//                String infoPackageId = httpRequest.getParameter("id");
//                if (infoPackageId != null) {
//                    // check if the info package belongs to the user
//                    // you can retrieve the info package using a service or repository and check if the user ID matches
//                    // if the info package doesn't belong to the user, return a 403 error
//                    // otherwise, continue with the request chain
//                }
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
//
package com.tbb.krazyolives.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class ReservationAuthorizationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userId = authentication.getName(); // assuming that the user ID is stored in the authentication's name field
            if (httpRequest.getRequestURI().startsWith("/auth/reservations")) {
                // check if the requested reservation belongs to the user
                String reservationId = httpRequest.getParameter("id");
                if (reservationId != null) {
                    // check if the reservation belongs to the user
                    // you can retrieve the reservation using a service or repository and check if the user ID matches
                    // if the reservation doesn't belong to the user, return a 403 error
                    // otherwise, continue with the request chain
                }
            } else if (httpRequest.getRequestURI().startsWith("/auth/info-packages")) {
                // check if the requested info package belongs to the user
                String infoPackageId = httpRequest.getParameter("id");
                if (infoPackageId != null) {
                    // check if the info package belongs to the user
                    // you can retrieve the info package using a service or repository and check if the user ID matches
                    // if the info package doesn't belong to the user, return a 403 error
                    // otherwise, continue with the request chain
                }
            }
        }
        chain.doFilter(request, response);
    }
}
