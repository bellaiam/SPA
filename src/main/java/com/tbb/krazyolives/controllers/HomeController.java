package com.tbb.krazyolives.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @Slf4j
public class HomeController {

//    @GetMapping
//    String getIndex() {
//        return "index";
//    }

    @GetMapping(value = {"/", "index"})
    public String viewHomePage() {
        return "index";
    }

    @GetMapping(value = {"/our-story"})
    public String viewOurStoryPage() {
        return "our-story";
    }

    @GetMapping(value = {"/menu"})
    public String viewOurMenuPage() {
        return "menu";
    }


    @GetMapping(value = {"/reservation"})
    public String viewReservationPage() {
        return "reservation";
    }


    @GetMapping(value = {"/gallery"})
    public String viewGalleryPage() {
        return "gallery";
    }

    @GetMapping(value = {"/get-in-touch"})
    public String viewGetInTouchPage() {
        return "get-in-touch";
    }

    @GetMapping(value = {"/login"})
    public String viewLoginPage() {
        return "login";
    }


    @GetMapping(value = {"/signup"})
    public String viewSignUpPage(){
        return "signup";}

}


//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @GetMapping("/403")
//    public String accessDenied(){
//        return "403";
//    }
//}

