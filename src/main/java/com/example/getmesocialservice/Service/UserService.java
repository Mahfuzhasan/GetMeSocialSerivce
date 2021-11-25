package com.example.getmesocialservice.Service;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//service  class is used for business logic creation
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getUser(){
        return userRepository.getUser();
    }

}
