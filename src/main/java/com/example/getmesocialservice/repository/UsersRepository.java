package com.example.getmesocialservice.repository;
import com.example.getmesocialservice.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<Users, String> {

    List<Users> findAllById(String iterable);
}
