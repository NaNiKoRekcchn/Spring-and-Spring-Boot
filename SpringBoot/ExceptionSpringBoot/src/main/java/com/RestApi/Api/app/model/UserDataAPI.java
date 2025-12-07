package com.RestApi.Api.app.model;

import lombok.Data;

@Data
public class UserDataAPI {
    private Integer id;
    private String name;
    private String email;

    public UserDataAPI(Integer id,String name,  String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
