package com.design.backend.splitwise.strategy;

import com.design.backend.splitwise.model.Expense;
import com.design.backend.splitwise.model.Transaction;
import com.design.backend.splitwise.model.User;
import com.design.backend.splitwise.model.UserExpense;
import org.springframework.stereotype.Component;

import java.util.*;
@Component("HeapSettleUpStrategy")
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        HashMap<User, Integer> expensesMap = new HashMap<>();
        for (Expense expense : expenses) {
            for (UserExpense expenseUser : expense.getPaidForUsers()) {
                if (expensesMap.containsKey(expenseUser.getUser())) {
                    expensesMap.put(expenseUser.getUser(), expensesMap.get(expenseUser.getUser()) + expenseUser.getAmount());
                } else {
                    expensesMap.put(expenseUser.getUser(), expenseUser.getAmount());
                }
            }
        }
        PriorityQueue<Map.Entry<User, Integer>> positiveHeap = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );
        PriorityQueue<Map.Entry<User, Integer>> negativeHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().compareTo(b.getValue())
        );

        for (Map.Entry<User, Integer> entry : expensesMap.entrySet()) {
            if (entry.getValue() > 0) {
                positiveHeap.offer(entry);
            } else if (entry.getValue() < 0) {
                negativeHeap.offer(entry);
            }
        }

        List<Transaction> settlements = new ArrayList<>();
        while (!positiveHeap.isEmpty() && !negativeHeap.isEmpty()) {
            Map.Entry<User, Integer> positive = positiveHeap.poll();
            Map.Entry<User, Integer> negative = negativeHeap.poll();

            int settlementAmount = Math.min(positive.getValue(), -negative.getValue());
            settlements.add(new Transaction(negative.getKey(), positive.getKey(), settlementAmount));

//            int positiveRemaining = positive.getValue() - settlementAmount;
//            int negativeRemaining = negative.getValue() + settlementAmount;
//
//            if (positiveRemaining > 0) {
//                positiveHeap.offer(new AbstractMap.SimpleEntry<>(positive.getKey(), positiveRemaining));
//            } else if (negativeRemaining < 0) {
//                negativeHeap.offer(new AbstractMap.SimpleEntry<>(negative.getKey(), negativeRemaining));
//            }

            positive.setValue(positive.getValue() - settlementAmount);
            negative.setValue(negative.getValue() + settlementAmount);

            if (positive.getValue() > 0) {
                positiveHeap.offer(positive);
            }
            if (negative.getValue() < 0) {
                negativeHeap.offer(negative);
            }
        }

        return settlements;
    }
}