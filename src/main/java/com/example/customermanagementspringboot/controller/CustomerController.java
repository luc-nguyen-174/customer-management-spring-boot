package com.example.customermanagementspringboot.controller;

import com.example.customermanagementspringboot.model.Customer;
import com.example.customermanagementspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }

}
