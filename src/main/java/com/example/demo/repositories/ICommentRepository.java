package com.example.demo.repositories;

import com.example.demo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost_PostId(Long Id);
}
