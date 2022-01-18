package com.example.pharmacia.service;

import com.example.pharmacia.model.Booking;
import com.example.pharmacia.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User loginUser(String email, String password);
    Long getTotalUsers();
    List<User> getAllUser();
}
