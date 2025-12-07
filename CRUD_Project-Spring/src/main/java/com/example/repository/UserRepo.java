package com.example.repository;

import com.example.db.DataBaseConnection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    private DataBaseConnection db;
//    if u dont create constructor than also it will inject since DataBaseConnection is a spring managed comonent.
    public UserRepo(DataBaseConnection db) {
        this.db = db;
    }

    public List<String> findAll(){
        return db.getUsers();
    }

    public void save(String user){
        db.addUser(user);
    }

}
