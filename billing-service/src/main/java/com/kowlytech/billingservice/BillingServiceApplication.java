package com.kowlytech.billingservice;

import com.kowlytech.billingservice.entities.Bill;
import com.kowlytech.billingservice.entities.ProductItem;
import com.kowlytech.billingservice.model.Customer;
import com.kowlytech.billingservice.model.Product;
import com.kowlytech.billingservice.repositories.BillRepository;
import com.kowlytech.billingservice.repositories.ProductItemRepository;
import com.kowlytech.billingservice.service.CustomerRestClient;
import com.kowlytech.billingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient)
    {
        return  args -> {
            Collection<Product> products = productRestClient.allProducts().getContent();
            Long customerID = 1L;
            Customer customer = customerRestClient.findCustomerById(customerID);
            if (customer == null)
                throw  new RuntimeException("Customer not found");
            Bill bill = new Bill();
            bill.setBillDate(new Date());
            bill.setCustomerID(customerID);
            bill.setCustomer(customer);
            Bill savedBill = billRepository.save(bill);
            products.forEach(product-> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductID(product.getId());
                productItem.setProduct(product);
                productItem.setPrice(product.getPrice());
                productItem.setQuantity(1 + new Random().nextInt(product.getQuantity()));
                productItem.setDiscount(Math.random());
                productItemRepository.save(productItem);
            });

        };
    }

}
