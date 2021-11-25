package com.example.getmesocialservice.Service;

import com.example.getmesocialservice.model.Albums;
import com.example.getmesocialservice.repository.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumsService {

    @Autowired
    private AlbumsRepository albumsRepository;
    public Albums saveAlbums(Albums albums) {
        return albumsRepository.save(albums);
    }
    public List<Albums> getAlbums(){
        return albumsRepository.findAll();
    }
    public Albums updateAlbums(Albums albums) {
        return  albumsRepository.save(albums);
    }
    //
//
//
    public List<Albums> getAlbumsById(String id){
        return albumsRepository.findAllById(id);
    }


    public void deleteAlbums(String id){
        albumsRepository.deleteById(id);
    }
}
