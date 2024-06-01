package com.crud_api.demo.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_api.demo.model.User;
import com.crud_api.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(User user) throws ExecutionException, InterruptedException {
        return userRepository.saveUser(user);
    }

    public User getUserById(String id) throws ExecutionException, InterruptedException {
        return userRepository.getUserById(id);
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException {
        return userRepository.updateUser(user);
    }

    public String deleteUser(String id) throws ExecutionException, InterruptedException {
        return userRepository.deleteUser(id);
    }

    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userRepository.getAllUsers();
    }
}