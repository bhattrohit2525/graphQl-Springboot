package com.graphqlspringboot.springbootgraphql.services;

import com.graphqlspringboot.springbootgraphql.entites.User;
import com.graphqlspringboot.springbootgraphql.helper.ExceptionHelper;
import com.graphqlspringboot.springbootgraphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //creating user
    public User createUser(User user){
        return userRepo.save(user);
    }

    //getting all users
    public List<User> getAllUser(){
        return  userRepo.findAll();
    }

    //getting user by id
    public User getUserById(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return user;
    }

    //deleting order
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;

    }
}
