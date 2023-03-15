package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_id_generator",
            sequenceName = "role_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_id_generator"
    )
    private Long RoleId;
    @Column(
            name = "role",
            nullable = false
    )
    private String title;
    @OneToOne(
            mappedBy = "role"
    )
    private Customer customer;

    public Role(Long roleId, String title) {
        RoleId = roleId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + RoleId +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role() {
    }

}
