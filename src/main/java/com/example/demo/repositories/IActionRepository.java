package com.example.demo.repositories;

import com.example.demo.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IActionRepository extends JpaRepository<Action, Long> {
    public List<Action> findByNature(String nature);
    @Query(
            value = "SELECT COUNT(*) FROM action WHERE nature = ?1 AND post_id = ?2",
            nativeQuery = true
    )
    public int countActions(String like, Long Id);
}