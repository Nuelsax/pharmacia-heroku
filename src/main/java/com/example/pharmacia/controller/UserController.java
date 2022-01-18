package com.example.pharmacia.controller;

import com.example.pharmacia.model.User;
import com.example.pharmacia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
   private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String registerUser(Model model) {
        //create user object to hold user data
//
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/Users")
    public String saveStudent(@ModelAttribute("user") User user, HttpServletRequest request ) {
        userService.saveUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:/main";

    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = user.getEmail();
        String password = user.getPassword();
        User person = userService.loginUser(email,password);
        System.out.println("this is the email" + email);
        System.out.println("this is the password" + password);
        System.out.println("nawa na here i dey oo");
        if(person == null) {
            return "reg";
        } else if(person.getFirstName().equals("Admin")){
             return "redirect:/adminpanel";
        } else {
            session.setAttribute("user", person);
            System.out.println("got here");
            return "redirect:/main";
        }
    }

    @GetMapping("/admin-panel")
    public String adminPanel(Model model) {
        //create user object to hold user data
//
        model.addAttribute("user", new User());
        System.out.println("HMMM its well");
        return "adminlog";
    }
//
//    @GetMapping("/login-form")
//    public String showLoginForm(Model model) {
//        //create user object to hold user data
////
//        model.addAttribute("user", new User());
//        System.out.println("HMMM its well");
//        return "reg";
//    }
//
//    @PostMapping("/loginAdmin")
//    public String loginAdmin(@ModelAttribute("user") User user, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String email = user.getEmail();
//        String password = user.getPassword();
//        User person = userService.loginUser(email,password);
//        System.out.println("this is the email for admin " + email);
//        System.out.println("this is the password for admin " + password);
//        System.out.println("nawa na here i dey oo");
//        if(person.getEmail().equals("admin@gmail.com")) {
//            System.out.println("i exceuted this");
//            return "adminpanel";
//        } else {
//            System.out.println("omo na this one i execute oo");
//            session.setAttribute("user", person);
//            System.out.println("got here");
//            return "adminlog";
//        }
//    }



}
