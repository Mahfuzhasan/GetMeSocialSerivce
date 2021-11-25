package com.example.getmesocialservice.Resource;

import com.example.getmesocialservice.Service.AlbumService;

import com.example.getmesocialservice.model.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
   private AlbumService albumService;
    @GetMapping ("/album")
    public List<Album> getAlbum(){ return albumService.getAlbum();}

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable("albumId") int albumId){
        return albumService.getAlbumById(albumId);
    }
    @PutMapping ("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId,album);
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);

    }

    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name="albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }

}


