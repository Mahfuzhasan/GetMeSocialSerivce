package com.example.getmesocialservice.repository;
import com.example.getmesocialservice.model.Albums;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumsRepository extends MongoRepository<Albums, String> {

    List<Albums> findAllById(String iterable);
}
