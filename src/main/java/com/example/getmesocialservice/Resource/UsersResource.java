package com.example.getmesocialservice.Resource;

import com.example.getmesocialservice.Service.FirebaseService;
import com.example.getmesocialservice.Service.UsersService;

import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.Users;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api")
public class UsersResource {

    @Autowired
    private UsersService usersService;
    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/users")
    public Users saveUsers(@RequestBody @Valid Users users) {
       
        return usersService.saveUsers(users);}
 
    
    @GetMapping ("/users")
    public List<Users> getUsers(){ return usersService.getUsers();}
    @PutMapping ("/users")
    public Users updateUsers( @RequestBody Users users){
        return usersService.updateUsers(users);
    }
    @DeleteMapping("/users")
    public void deleteUsers(@RequestParam(name="id") String id){
        usersService.deleteUsers(id);
    }
    @GetMapping("/users/id")
    public List<Users> getUsersById(@RequestParam(name="id") String id){
        return usersService.getUsersById(id);
    }






}


