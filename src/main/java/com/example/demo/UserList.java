package com.example.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserList {
    private List<User> users;
    public UserList() {
        users = new ArrayList<>();
    }
}
