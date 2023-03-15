package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @SequenceGenerator(
            name = "post_type_id_generator",
            sequenceName = "post_type_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_type_id_generator"
    )
    private Long CommentId;

    @ManyToOne(
            cascade = CascadeType.REMOVE
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "CustomerId"
    )
    private  Customer customer;
    @ManyToOne(
            cascade = CascadeType.REMOVE
    )
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "PostId"
    )
    private Post post;
    private String comment;

}
