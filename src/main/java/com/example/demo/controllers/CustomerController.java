package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Role;
import com.example.demo.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    @Autowired
    ICustomerRepository customerRepository;
    CustomerController(ICustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    @GetMapping("/")
    public List<Customer> getCustomers() {
       return customerRepository.findAll();
    }

    @GetMapping("/native")
    public List<Customer> getCustomersNative() {
        return customerRepository.getAllUser();
    }

    record CustomerDAO(String name, String email, int age, LocalDate dob, Role role) {}

    @PostMapping("/create")
    public void createCustomer(@RequestBody CustomerDAO body) {
        Customer customer = new Customer();
        customer.setName(body.name);
        customer.setEmail(body.email);
        customer.setAge(body.age);
        customer.setDob(body.dob);
        customer.setRole(body.role);
        customerRepository.save(customer);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteCustomer(@PathVariable("userId") Long id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/update/{userId}")
    public  void updateCustomer(@PathVariable("userId") Long id, @RequestBody CustomerDAO body) {
        var customerToUpdate = customerRepository.findById(id);
        if(customerToUpdate.isPresent()) {
            Customer customer = customerToUpdate.get();
            customer.setName(body.name);
            customer.setEmail(body.email);
            customer.setAge(body.age);
            customer.setDob(body.dob);
            customerRepository.save(customer);
        }
    }
    @PutMapping("/native/{userName}")
    public int updateCustomerNative(@PathVariable("userName") String name, @RequestBody CustomerDAO body ) {
        return customerRepository.updateUserNative(body.email, name);
    }

    @GetMapping("/{userName}")
    public Customer findByName(@PathVariable("userName") String name) {
        return customerRepository.findByName(name);
    }

}