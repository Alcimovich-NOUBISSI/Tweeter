package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class FollowId implements Serializable {
    @OneToOne()
    @JoinColumn(
            name = "follower_id",
            referencedColumnName = "CustomerId"
    )
    private Customer follower;
    @OneToOne()
    @JoinColumn(
            name = "following_id",
            referencedColumnName = "CustomerId"
    )
    private Customer following;

}
