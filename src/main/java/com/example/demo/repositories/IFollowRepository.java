package com.example.demo.repositories;

import com.example.demo.entities.Follow;
import com.example.demo.entities.FollowId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IFollowRepository extends JpaRepository<Follow, FollowId> {
}
