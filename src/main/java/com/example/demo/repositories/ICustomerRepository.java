package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    @Query(
            value = "select * from customer",
            nativeQuery = true
    )
    List<Customer> getAllUser();
    @Modifying
    @Transactional
    @Query(
            value = "update customer set email = ?1 where name = ?2",
            nativeQuery = true
    )
    int updateUserNative(String email, String name);


}
