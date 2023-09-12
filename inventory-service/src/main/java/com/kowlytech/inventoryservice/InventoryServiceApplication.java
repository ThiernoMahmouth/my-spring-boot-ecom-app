package com.kowlytech.inventoryservice;

import com.kowlytech.inventoryservice.entities.Product;
import com.kowlytech.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository, RepositoryRestConfiguration restConfig)
    {
        return args -> {
            restConfig.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("Ordinateur").price(250000).quantity(7).build(),
                            Product.builder().name("Téléphone").price(125000).quantity(21).build(),
                            Product.builder().name("Tablette").price(200000).quantity(10).build()
                    )
            );

            productRepository.findAll().forEach(c -> System.out.println(c));
        };
    }
}
