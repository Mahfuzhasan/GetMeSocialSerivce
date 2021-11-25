package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList= new ArrayList();


    public List<Album> getAlbum(){
       // Album album = new Album(1,  "Canada",  "North_America" ,  "fbaa.com");
        return  albumList;
    }

    public Album saveAlbum(Album album) {
       album.setAlbumId(albumList.size()+1);
        albumList.add(album);
        return album;
    }

    public Album getAlbumById(int albumId){
        for(Album album:albumList){
            if(album.getAlbumId()==albumId){
                return album;
            }
        } return null;
    }


    public Album updateAlbum(int albumId, Album album) {
        for(Album u:albumList){
            if(u.getAlbumId()==albumId){
                u.setName(album.getName());
                u.setDescription(album.getDescription());
                u.setCoverPicUrl(album.getCoverPicUrl());
                return album;
            }
        } return null;
    }
    public  Album deleteAlbum(int albumId){
        Album  delectedAlbum = null;
        for (Album u:albumList){
            if (u.getAlbumId()==albumId){
                delectedAlbum=u;
                albumList.remove(u);
            }
        } return delectedAlbum;
    }
}


