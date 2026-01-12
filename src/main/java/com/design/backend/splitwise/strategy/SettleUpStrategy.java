package com.design.backend.splitwise.strategy;

import com.design.backend.splitwise.model.Expense;
import com.design.backend.splitwise.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}