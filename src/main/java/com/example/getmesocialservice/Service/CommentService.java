package com.example.getmesocialservice.Service;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> getComment(){
        return commentRepository.findAll();
    }
    public Comment updateComment(Comment comment) {
        return  commentRepository.save(comment);
    }
    //
//
//
    public List<Comment> getCommentById(String id){
        return commentRepository.findAllById(id);
    }


    public void deleteComment(String id){
        commentRepository.deleteById(id);
    }
}
