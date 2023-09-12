package com.kowlytech.billingservice.repositories;

import com.kowlytech.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long>
{
}
