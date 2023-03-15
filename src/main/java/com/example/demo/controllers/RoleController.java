package com.example.demo.controllers;

import com.example.demo.entities.Role;
import com.example.demo.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/role")
public class RoleController {

    @Autowired
    private IRoleRepository iroleRepository;

    @GetMapping("/")
    public List<Role> getRoles(){
        return iroleRepository.findAll();
    }

}