package com.example.pharmacia.service.impl;

import com.example.pharmacia.model.User;
import com.example.pharmacia.repository.UserRepository;
import com.example.pharmacia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email,password);
    }

    @Override
    public Long getTotalUsers() {
        return userRepository.count();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
