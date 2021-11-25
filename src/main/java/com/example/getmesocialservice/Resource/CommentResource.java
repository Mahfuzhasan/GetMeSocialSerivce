package com.example.getmesocialservice.Resource;

import com.example.getmesocialservice.Service.CommentService;

import com.example.getmesocialservice.Service.FirebaseService;
import com.example.getmesocialservice.model.Comment;

import com.example.getmesocialservice.model.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api")
public class CommentResource {

    @Autowired
    private CommentService commentService;


    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/comments")
    public Comment saveComment(@RequestBody @Valid Comment comment, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.auth(idToken);
        if(firebaseUser != null){
        return commentService.saveComment(comment);}
        return null;
    }
    @GetMapping ("/comments")
    public List<Comment> getComment( @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException { 
    	FirebaseUser firebaseUser = firebaseService.auth(idToken);
        if(firebaseUser != null){
        
        	
    	return commentService.getComment();}
        return null;
    }
    @PutMapping ("/comments")
    public String updateComment( 
    		@RequestBody Comment comment, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
       String id= comment.getId();
    	FirebaseUser firebaseUser = firebaseService.auth(idToken);
        String database_email= commentService.getCommentById(id).get(0).getCreatedBy();
    	String  user_email= FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
        if(firebaseUser != null ){
        	if (database_email.equals(user_email)) {
        	commentService.updateComment(comment);
        return "It is updated";	}
        }
        return "you are not authtorized to do so, you did not created this one buddy";
 
    }
    
    @DeleteMapping("/comments")
    public String deleteComment(
    		@RequestParam(name="id") String id, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.auth(idToken);
        String database_email= commentService.getCommentById(id).get(0).getCreatedBy();
    	String  user_email= FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
        if(firebaseUser != null && database_email.equals(user_email)){
        	commentService.deleteComment(id);
        return "It is deleted";	
        }
        return "you are not authtorized to do so, you did not created this one buddy";
    }
    		
    		
    		
    		
    
    @GetMapping("/comments/id")
    public List<Comment> getCommentById(@RequestParam(name="id") String id,@RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException { 
    	FirebaseUser firebaseUser = firebaseService.auth(idToken);
        if(firebaseUser != null){  	
    	return commentService.getCommentById(id);}
        return null;
    }
    		
    		
    		
    		
    		
    		
    		
    





}


