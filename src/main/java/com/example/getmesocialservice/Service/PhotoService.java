package com.example.getmesocialservice.Service;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }
    public List<Photo> getPhoto(){
        return photoRepository.findAll();
    }
    public Photo updatePhoto(Photo photo) {
        return  photoRepository.save(photo);
    }
//
//
//
    public List<Photo> getPhotoById(String id){
        return photoRepository.findAllById(id);
    }


    public void deletePhoto(String id){
          photoRepository.deleteById(id);
    }
}
