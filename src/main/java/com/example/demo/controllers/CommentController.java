package com.example.demo.controllers;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Post;
import com.example.demo.repositories.ICommentRepository;
import com.example.demo.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/comment")
public class CommentController {
    
    @Autowired
    ICommentRepository iCommentRepository;

    @Autowired
    IPostRepository iPostRepository;

    record CommentDAO(Customer customer, String comment){}

    @PostMapping("/{postId}")
    public void commentPost(@PathVariable("postId") Long Id , @RequestBody CommentDAO body) {
        var postToUpdate = iPostRepository.findById(Id);
        if(postToUpdate.isPresent()){
            Post post = postToUpdate.get();
            Comment comment = new Comment().builder()
                    .post(post)
                    .customer(body.customer)
                    .comment(body.comment)
                    .build();
            iCommentRepository.save(comment);
        }
    }

    @GetMapping("/{postId}")
    public List<Comment> getComment(@PathVariable("postId") Long Id) {
        return iCommentRepository.findByPost_PostId(Id);
    }

}
