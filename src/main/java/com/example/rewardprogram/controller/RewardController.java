package com.example.rewardprogram.controller;

import com.example.rewardprogram.dao.CustomerRepository;
import com.example.rewardprogram.entity.Customer;
import com.example.rewardprogram.model.Reward;
import com.example.rewardprogram.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")

public class RewardController {
    @Autowired
    RewardService rewardService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/reward/byuser")
    public Reward getRewardByCustomerId(@RequestParam Long customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null){
            throw new IllegalArgumentException("The user does not exist!");
        }
        return rewardService.getRewardByCustomerId(customerId);
    }
}
