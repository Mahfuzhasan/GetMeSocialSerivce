package com.example.getmesocialservice.Resource;

import com.example.getmesocialservice.Service.PhotoService;

import com.example.getmesocialservice.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;
    @PostMapping("/photos")
    public Photo savePhoto(@RequestBody @Valid Photo photo){
        return photoService.savePhoto(photo);
    }
    @GetMapping ("/photos")
   public List<Photo> getPhoto(){ return photoService.getPhoto();}
    @PutMapping ("/photos")
   public Photo updatePhoto( @RequestBody Photo photo){
        return photoService.updatePhoto(photo);
   }
    @DeleteMapping("/photos")
    public void deletePhoto(@RequestParam(name="id") String id){
         photoService.deletePhoto(id);
    }
    @GetMapping("/photos/id")
    public List<Photo> getPhotoById(@RequestParam(name="id") String id){
        return photoService.getPhotoById(id);
    }






}


