package com.example.demo.controllers;

import com.example.demo.entities.Action;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Post;
import com.example.demo.repositories.IActionRepository;
import com.example.demo.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/action")
public class ActionController {

    @Autowired
    IActionRepository iActionRepository;
    @Autowired
    IPostRepository iPostRepository;

    record ActionDAO(Customer customer, String nature, String text){}

    @PostMapping("/like/{postId}")
    public void likePost(@PathVariable("postId") Long post_id, @RequestBody ActionDAO body) {
        var postToUpdate = iPostRepository.findById(post_id);
        if(postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            Action action = new Action().builder()
                    .post(post)
                    .customer(body.customer)
                    .nature("like")
                    .build();
            iActionRepository.save(action);
        }
    }

    @PostMapping("/bookmark/{postId}")
    public void bookmarkPost(@PathVariable("postId") Long post_id, @RequestBody ActionDAO body) {
        var postToUpdate = iPostRepository.findById(post_id);
        if(postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            Action action = new Action().builder()
                    .post(post)
                    .customer(body.customer)
                    .nature("bookmark")
                    .build();
            iActionRepository.save(action);
        }

    }

    @PostMapping("/repost/{postId}")
    public void rePost(@PathVariable("postId") Long post_id, @RequestBody ActionDAO body) {
        var postToUpdate = iPostRepository.findById(post_id);
        if(postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            Action action = new Action().builder()
                    .post(post)
                    .customer(body.customer)
                    .nature("repost")
                    .text(body.text)
                    .build();
            iActionRepository.save(action);
        }

    }

    @GetMapping("/likes/{postId}")
    public List<Action> getLikes(@PathVariable("postId") Long Id){
        return iActionRepository.findByNature("like");
    }

    @GetMapping("/bookmarks/{postId}")
    public List<Action> getBookmarks(@PathVariable("postId") Long Id){
        return iActionRepository.findByNature("bookmark");
    }

    @PostMapping("countLikes/{postId}")
    public int countLikes(@PathVariable("postId") Long Id , @RequestBody String nature){
        return iActionRepository.countActions(nature, Id);
    }

}
