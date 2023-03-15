package com.example.demo.daos;

import java.time.LocalDate;

 record CustomerDAO(String name, String email, int age, LocalDate dob) {}
