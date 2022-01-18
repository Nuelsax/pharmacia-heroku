package com.example.pharmacia.controller;

import com.example.pharmacia.model.Booking;
import com.example.pharmacia.model.User;
import com.example.pharmacia.service.BlogService;
import com.example.pharmacia.service.BookingService;
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
public class BookingController {
    private BookingService bookingService;
    private UserService userService;
    private BlogService blogService;
    @Autowired
    public BookingController(BookingService bookingService, UserService userService, BlogService blogService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping("/main")
    public  String welcomePage(Model model) {


        model.addAttribute("getBlogs", blogService.getAllBlogPosts());
        model.addAttribute("book", new Booking());

        return "main";
    }



    @PostMapping("/book")
    public String saveBookings(@ModelAttribute("book") Booking book, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        String userName = user.getFirstName();
//        User person = new User(id,userName);

        User user1 = book.getUser();

        if(user1 == null) {
            book.setUser(user);
        }

        System.out.println("got here");
        bookingService.saveBooking(book);
        return "redirect:/main";
    }

    @GetMapping("/adminpanel")
    public  String adminHomePage(Model model) {


        model.addAttribute("listofBooking", bookingService.getAllBooking());
        model.addAttribute("listofUsers", userService.getAllUser());
        model.addAttribute("totalbooking", bookingService);
        model.addAttribute("totalUsers", userService);


        return "adminpanel";
    }


}
