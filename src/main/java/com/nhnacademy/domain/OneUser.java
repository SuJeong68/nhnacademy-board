package com.nhnacademy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneUser implements User {

    private String id;
    private String password;
    private String name;
    private String profileFileName;

    public OneUser(String id, String password, String name, String profileFileName) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profileFileName = profileFileName;
    }
}
