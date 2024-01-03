package com.kowlytech.customerservice.services;

import com.kowlytech.customerservice.dto.CustomerDTORequest;
import com.kowlytech.customerservice.entities.Customer;
import com.kowlytech.customerservice.mappers.CustomerMapper;
import com.kowlytech.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService
{
    private final CustomerRepository customerRepository;
    //private final CustomerMapper customerMapper;
    public Customer save (CustomerDTORequest customerDTORequest)
    {
        //Logger
        //Customer customer = customerMapper.CustomerDTORequestToCustomer(customerDTORequest);
        log.info("CustomerService::save() with params {}", customerDTORequest);
        Customer customer = Customer.builder()
                .name(customerDTORequest.getName())
                .email(customerDTORequest.getEmail())
                .build();
        return customerRepository.save(customer);
    }

    public Customer update(Long id, CustomerDTORequest customerDTORequest)
    {
        //Logger
        log.info("CustomerService::update() with params {} {}", id, customerDTORequest);

        Customer customer = this.findById(id);
        if (customer !=  null)
        {
            customer.setName(customerDTORequest.getName());
            customer.setEmail(customerDTORequest.getEmail());
            return customerRepository.save(customer);

        }
        return null;
    }

    public Customer findById(Long id)
    {
        //Logger
        log.info("CustomerService::findById() with param {}", id);
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll()
    {
        //Logger
        log.info("CustomerService::findAll()");
        return customerRepository.findAll();
    }
}
