package com.brookr.FloatyShop.Controllers;

import com.brookr.FloatyShop.Models.Customer;
import com.brookr.FloatyShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return (List) customerRepository.findAll();
    }

    @PatchMapping("/customers/{id}/status")
    public Customer patchStatus(@PathVariable String id) {
        Customer customer = customerRepository.findById(id).get();
        customer.toggleVipStatus();

        customerRepository.save(customer);

        return customer;
    }
}
