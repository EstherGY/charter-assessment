package com.example.rewardprogram.service;

import com.example.rewardprogram.dao.TransactionRepository;
import com.example.rewardprogram.entity.Transaction;
import com.example.rewardprogram.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardService {

    @Autowired
    TransactionRepository transactionRepository;

    public Reward getRewardByCustomerId(Long customerId){

        //get the timestamp to separate each month
        Timestamp previousMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(30));
        Timestamp previousTwoMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(60));
        Timestamp previousThreeMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(90));

        //get the transactions for each month
        List<Transaction> previousMonthTransaction = transactionRepository.findTransactionByCustomerIdAndTransactionDateBetween(
                customerId, previousMonthTimestamp, Timestamp.from(Instant.now()));

        List<Transaction> previousTwoMonthTransaction = transactionRepository.findTransactionByCustomerIdAndTransactionDateBetween(
                customerId, previousTwoMonthTimestamp, previousMonthTimestamp);

        List<Transaction> previousThreeMonthTransaction = transactionRepository.findTransactionByCustomerIdAndTransactionDateBetween(
                customerId, previousThreeMonthTimestamp, previousTwoMonthTimestamp);

        //calculate the reward for each month
        Long previousReward = getRewardPerMonth(previousMonthTransaction);
        Long previousTwoReward = getRewardPerMonth(previousTwoMonthTransaction);
        Long previousThreeReward = getRewardPerMonth(previousThreeMonthTransaction);

        //create the reward object for result
        Reward reward = new Reward();

        reward.setCustomerId(customerId);
        reward.setPreviousMonth(previousReward);
        reward.setPreviousTwoMonth(previousTwoReward);
        reward.setPreviousThreeMonth(previousThreeReward);
        reward.setTotal(previousReward + previousTwoReward + previousThreeReward);

        return reward;
    }

    private Long getRewardPerMonth(List<Transaction> transactions) {
        Long result = (long)0;
        for(int i = 0; i<transactions.size(); i++){
            result += RewardCalculator(transactions.get(i));
        }

        return result;
    }

    private Long RewardCalculator(Transaction transaction) {
        if (transaction.getTransactionAmount() > 50 && transaction.getTransactionAmount() <= 100) {
            return Math.round(transaction.getTransactionAmount() - 50);
        } else if (transaction.getTransactionAmount() > 100) {
            return Math.round(transaction.getTransactionAmount() - 100) * 2 + 50;
        }

        return (long)0;
    }
}
