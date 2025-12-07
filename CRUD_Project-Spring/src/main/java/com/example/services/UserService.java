package com.example.services;

import org.springframework.stereotype.Service;
import com.example.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(String name) {
        userRepo.save(name);
    }

    public List<String> getAllUser() {
     return userRepo.findAll();
    }
}
