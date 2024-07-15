package com.graphqlspringboot.springbootgraphql.controllers;

import com.graphqlspringboot.springbootgraphql.entites.User;
import com.graphqlspringboot.springbootgraphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user API
    @MutationMapping
    public User createUser(@Argument String name , @Argument String phone, @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name="getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @QueryMapping(name="getUser")
    public User getUser(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument  int userId){
        return userService.deleteUser(userId);
    }
}
