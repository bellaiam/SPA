package com.tbb.krazyolives.controllers;

import com.tbb.krazyolives.models.User;
import com.tbb.krazyolives.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "users")
public class UserController {

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // display list of users
    @GetMapping("/listUsers")
    public String viewUsersPage(Model model) {
        model.addAttribute("listUsers",userService.getAllUsers());
        return "user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
     userService.saveUsers(user);
        return "redirect:/users/listUsers";
    }



    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get user from the service
        User user = userService.getUserById(id);

        // set  user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete  user method
        this. userService.deleteUserById(id);
        return "redirect:/users/listUsers";
    }}