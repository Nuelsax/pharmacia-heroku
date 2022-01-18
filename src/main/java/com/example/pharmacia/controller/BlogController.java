package com.example.pharmacia.controller;

import com.example.pharmacia.model.Blog;
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
public class BlogController {
    private BlogService blogService;
    private UserService userService;
    private BookingService bookingService;

  @Autowired
    public BlogController(BlogService blogService, UserService userService, BookingService bookingService) {
        this.blogService = blogService;
        this.userService = userService;
        this.bookingService = bookingService;
    }
//    @GetMapping("/blog")
//    public  String blogHomePage(Model model) {
//
//
//        model.addAttribute("listofBooking", bookingService.getAllBooking());
//        model.addAttribute("listofUsers", userService.getAllUser());
//        model.addAttribute("totalbooking", bookingService);
//        model.addAttribute("totalUsers", userService);
//
//        model.addAttribute("book", new Booking());
//
//        return "blog";
//    }


    @GetMapping("/blog")
    public  String blogPage(Model model) {


        model.addAttribute("listofBooking", bookingService.getAllBooking());
        model.addAttribute("listofUsers", userService.getAllUser());
        model.addAttribute("totalbooking", bookingService);
        model.addAttribute("totalUsers", userService);
        model.addAttribute("blog", new Blog());

        model.addAttribute("book", new Booking());

        return "blog";
    }

    @PostMapping("/post")
    public String saveBlog(@ModelAttribute("blog") Blog blog, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user2 = (User) session.getAttribute("user");
//        Long id = user2.getId();
//        String userName = user2.getFirstName();
////        User person = new User(id,userName);

        User user1 = blog.getUser();

        if(user1 == null) {
            blog.setUser(user2);
        }

        System.out.println("got here");
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }
}
