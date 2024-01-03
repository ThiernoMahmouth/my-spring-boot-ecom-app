package com.kowlytech.customerservice;

import com.kowlytech.customerservice.entities.Customer;
import com.kowlytech.customerservice.repositories.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepositoryTest
{
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveCustomer()
    {
        Customer customer = Customer.builder()
                .name("Korka")
                .email("korka@email.gn")
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
    }
}
