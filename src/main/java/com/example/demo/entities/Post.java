package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_id_generator",
            sequenceName = "post_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_generator"
    )
    private Long postId;
    private String text;
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "CustomerId"
    )
    private Customer customer;

}
