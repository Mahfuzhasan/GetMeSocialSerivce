package com.example.getmesocialservice.Resource;

import com.example.getmesocialservice.Service.AlbumsService;

import com.example.getmesocialservice.model.Albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api")
public class AlbumsResource {

    @Autowired
    private AlbumsService albumsService;
    @PostMapping("/albums")
    public Albums saveAlbums(@RequestBody @Valid Albums albums){
        return albumsService.saveAlbums(albums);
    }
    @GetMapping ("/albums")
    public List<Albums> getAlbums(){ return albumsService.getAlbums();}
    @PutMapping ("/albums")
    public Albums updateAlbums( @RequestBody Albums albums){
        return albumsService.updateAlbums(albums);
    }
    @DeleteMapping("/albums")
    public void deleteAlbums(@RequestParam(name="id") String id){
        albumsService.deleteAlbums(id);
    }
    
    
    
    @GetMapping("/albums/id")
    public List<Albums> getAlbumsById(@RequestParam(name="id") String id){
        return albumsService.getAlbumsById(id);
    }






}


