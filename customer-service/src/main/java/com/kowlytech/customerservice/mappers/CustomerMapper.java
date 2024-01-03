package com.kowlytech.customerservice.mappers;

import com.kowlytech.customerservice.dto.CustomerDTORequest;
import com.kowlytech.customerservice.entities.Customer;


//@Mapper
public interface CustomerMapper
{
    Customer CustomerDTORequestToCustomer(CustomerDTORequest customerDTORequest);
    CustomerDTORequest CustomerToCustomerDTORequest(Customer customer);
}
