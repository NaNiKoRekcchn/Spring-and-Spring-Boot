package com.example.services;

import com.example.model.UserSpringCRUDJPA;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserSpringCRUDJPA createUser(UserSpringCRUDJPA user) {
        return userRepo.save(user);
    }
}
