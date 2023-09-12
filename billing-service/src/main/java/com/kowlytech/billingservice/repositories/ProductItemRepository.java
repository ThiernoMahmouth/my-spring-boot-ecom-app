package com.kowlytech.billingservice.repositories;

import com.kowlytech.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long>
{
}
