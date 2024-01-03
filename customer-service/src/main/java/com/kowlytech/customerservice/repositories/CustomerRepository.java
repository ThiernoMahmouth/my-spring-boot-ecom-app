package com.kowlytech.customerservice.repositories;

import com.kowlytech.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}
