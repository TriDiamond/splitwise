package com.design.backend.splitwise.impl;

import com.design.backend.splitwise.model.Expense;
import com.design.backend.splitwise.model.ExpenseGroup;
import com.design.backend.splitwise.repository.ExpenseGroupRepository;
import com.design.backend.splitwise.repository.UserExpenseRepository;
import com.design.backend.splitwise.repository.UserRepository;
import com.design.backend.splitwise.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettleUpServiceImpl implements SettleUpService {
    private ExpenseGroupRepository expenseGroupRepository;
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    public SettleUpServiceImpl(ExpenseGroupRepository expenseGroupRepository,
                               UserRepository userRepository,
                               UserExpenseRepository userExpenseRepository){
        this.expenseGroupRepository = expenseGroupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void settleUpGroup(String groupName, String userName) {
     /*
      * 1) passing group get respective group
      * 2) get all expense respective user had to pay
      * 3) Using settle Strategy also (Heap Strategy)
      */
        Optional<ExpenseGroup> expenseGroupOptional = expenseGroupRepository.findByGroupName(groupName);
        if(expenseGroupOptional.isEmpty()){
            throw new RuntimeException("Group Not exists in the database");
        }
        ExpenseGroup expenseGroup = expenseGroupOptional.get();



    }

    @Override
    public void settleUpUser(String groupName, String userName) {

    }
}
/*
 * 1) get userExpense by passingGroup
 * 2) get userExpense by passingUser
 */