package com.tbb.krazyolives.controllers;


import com.tbb.krazyolives.data.ReservationRepository;
import com.tbb.krazyolives.data.UserRepository;
import com.tbb.krazyolives.models.Reservation;
import com.tbb.krazyolives.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller

public class ReservationController {

    UserRepository userRepository;
    ReservationRepository reservationRepository;

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(UserRepository userRepository, ReservationService reservationService) {
        this.userRepository = userRepository;
        this.reservationService = reservationService;
    }


//    @GetMapping
//    public String getAllReservations(Model model){
//        model.addAttribute("reservations", reservationService.getAllReservations());
//        return "reservation-list";
//    }

    //display list of reservations
    @GetMapping("/listReservations")
    public String viewReservationPage(Model model){
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "reservation-list";
    }

    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        // create model attribute to bind form data
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "reservation";
    }
    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
//              if (userRepository.findById(reservation.getId()).isEmpty() )
//           return "redirect:/showNewReservationForm";
//       reservation.setUser(userRepository.findById(reservation.getId()).get());
        // save reservation to database
       reservationService.saveReservation(reservation);
        return "redirect:/listReservations";

    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get reservation from the service
        Reservation reservation = reservationService.getReservationById(id);

        // set reservation as a model attribute to pre-populate the form
        model.addAttribute("reservation", reservation);
        return "update-reservation";
    }

//    @PostMapping("/saveupdatereservation")
//    public String saveUpdateCourse(RedirectAttributes model, @ModelAttribute("reservation")Reservation reservation){
//        reservationService.saveOrUpdate(reservation);
//        model.addFlashAttribute("reservation",reservationService.findById(reservation.getId()));
//        return "update-reservation";}

    @GetMapping("/deleteReservation/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        // call delete employee method
        this.reservationService.deleteReservationById(id);
        return "redirect:/listReservations";
    }

}
