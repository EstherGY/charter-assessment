package com.example.rewardprogram.dao;

import com.example.rewardprogram.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Customer findByCustomerId(Long customerId);
}
