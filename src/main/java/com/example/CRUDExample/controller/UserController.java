package com.example.CRUDExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDExample.model.User;
import com.example.CRUDExample.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping(value = "/users/{userId}")
    public void updateUser(@RequestBody User user, @PathVariable Long userId){
         userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
         userService.deleteUser(userId);
    }

}
