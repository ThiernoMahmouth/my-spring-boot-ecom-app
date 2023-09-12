package com.kowlytech.customerservice;

import com.kowlytech.customerservice.entities.Customer;
import com.kowlytech.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfig)
    {
        return args -> {
            restConfig.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
              List.of(
                      Customer.builder().name("Fatoumata").email("fatima@kowly.group").build(),
                      Customer.builder().name("Thierno").email("thierno@kowly.group").build(),
                      Customer.builder().name("Mariama").email("mariama@kowly.group").build()
                      )
            );

            customerRepository.findAll().forEach(c -> System.out.println(c));
        };
    }

}
