package com.example.getmesocialservice.model;


import com.example.getmesocialservice.validation.ValidName;
import org.springframework.data.annotation.Id;

public class Photo {

    @Id
    private String id;
    private String albumId;
   
    private String createdby;
    private String photoUrl;
    public String getPhotoUrl() {
		return photoUrl;
	}



	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	private  String dateCreated;

    public Photo(String albumId, String createdby, String dateCreated, String photoUrl) {
        this.albumId = albumId;
        this.createdby = createdby;
        this.dateCreated = dateCreated;
       this.photoUrl =photoUrl;
    }

   

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
