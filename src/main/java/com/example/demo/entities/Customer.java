package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    private Long CustomerId;
    private  String name;
    @Column(nullable = false)
    private String email;
    private int age;
    @Column(name="date_of_birth")
    private LocalDate dob;
    @OneToOne(
            cascade = CascadeType.ALL,
            optional =  false
    )
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "RoleId"
    )
    private Role role;

}
