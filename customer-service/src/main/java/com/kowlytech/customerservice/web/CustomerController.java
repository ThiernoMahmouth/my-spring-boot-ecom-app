package com.kowlytech.customerservice.web;

import com.kowlytech.customerservice.dto.CustomerDTORequest;
import com.kowlytech.customerservice.entities.Customer;
import com.kowlytech.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController
{
    private final CustomerService customerService;
    @GetMapping
    public List<Customer> findAll()
    {
        log.info("CustomerController::findAll()");
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id)
    {
        log.info("CustomerController::findById() with param {}", id);
        return customerService.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody CustomerDTORequest customerDTORequest)
    {
        log.info("CustomerController::save() with param {}", customerDTORequest);
        return customerService.save(customerDTORequest);
    }
}
