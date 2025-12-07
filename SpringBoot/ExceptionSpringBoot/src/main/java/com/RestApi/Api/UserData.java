package com.RestApi.Api;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class UserData {
    private String id;
    private String name;
    private String email;

    public UserData(String name, String id, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
