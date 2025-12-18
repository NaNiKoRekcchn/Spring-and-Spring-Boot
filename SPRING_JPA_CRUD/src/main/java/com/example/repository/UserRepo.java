package com.example.repository;

import com.example.model.UserSpringCRUDJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserSpringCRUDJPA,Long> {
}
