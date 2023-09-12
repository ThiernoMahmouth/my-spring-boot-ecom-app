package com.kowlytech.billingservice.web;

import com.kowlytech.billingservice.entities.Bill;
import com.kowlytech.billingservice.repositories.BillRepository;
import com.kowlytech.billingservice.repositories.ProductItemRepository;
import com.kowlytech.billingservice.service.CustomerRestClient;
import com.kowlytech.billingservice.service.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillRestController
{
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id)
    {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.findProductById(productItem.getProductID()));
        });
        return  bill;
    }
}
