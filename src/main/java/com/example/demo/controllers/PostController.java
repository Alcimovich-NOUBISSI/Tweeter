package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Post;
import com.example.demo.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {
    @Autowired
    IPostRepository ipostRepository;

    record PostDAO (Long postId, String text, Customer customer) {}

    @GetMapping("")
    public List<Post> getAllPosts(){
        return ipostRepository.findAll();
    }

    @PostMapping("/createPost")
    public void createPost(@RequestBody PostDAO body){
        Post post = new Post().builder()
                .text(body.text)
                .customer(body.customer)
                .build();
        ipostRepository.save(post);
    }

    @PutMapping("/edit/{postId}")
    public void editPost(@PathVariable("postId") Long Id, @RequestBody PostDAO body){
        var postToUpdate = ipostRepository.findById(Id);
        if(postToUpdate.isPresent()){
            Post post = postToUpdate.get();
            post.setText(body.text);
            ipostRepository.save(post);
        }
    }

    @DeleteMapping("/delete/{postId}")
    public void deletePost(){}


}