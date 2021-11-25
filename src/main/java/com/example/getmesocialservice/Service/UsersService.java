package com.example.getmesocialservice.Service;

import com.example.getmesocialservice.model.Users;
import com.example.getmesocialservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
    public Users updateUsers(Users users) {
        return   usersRepository.save(users);
    }
    //
//
//
    public List<Users> getUsersById(String id){
        return usersRepository.findAllById(id);
    }


    public void deleteUsers(String id){
        usersRepository.deleteById(id);
    }
}
