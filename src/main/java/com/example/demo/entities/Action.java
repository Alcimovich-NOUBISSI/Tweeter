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
public class Action {
    @Id
    @SequenceGenerator(
            name = "action_id_generator",
            sequenceName = "action_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "action_id_generator"
    )
    private Long ActionId;
    @ManyToOne()
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "PostId"
    )
    private Post post;
    @ManyToOne()
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "CustomerId"
    )
    private Customer customer;
    @Column(
            nullable = false
    )
    private String nature;
    private String text;


}
