package com.example.trainingvideorental.Customer.controller;

import com.example.trainingvideorental.Customer.model.Customer;
import com.example.trainingvideorental.Customer.repository.CustomerRepository;
import com.example.trainingvideorental.Movies.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //get all customer

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

//get videos by rest api

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable @RequestBody Long id )  {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer nor Exist  with id : " + id));
        return ResponseEntity.ok(customer);
    }


    //Update videos rest API

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer nor Exist  with id : " + id));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setUserName(customerDetails.getUserName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setAddress(customerDetails.getAddress());
        customer.setEmail(customerDetails.getEmail());

        Customer updateVideo = customerRepository.save(customer);

        return ResponseEntity.ok(customerDetails);
    }

    // delete videos rest API

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVideo(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer nor Exist with id : " + id));

        customerRepository.delete(customer);
        Map<String, Boolean> response =  new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
