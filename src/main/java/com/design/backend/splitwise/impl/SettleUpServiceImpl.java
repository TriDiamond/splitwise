package com.design.backend.splitwise.impl;

import com.design.backend.splitwise.model.Expense;
import com.design.backend.splitwise.model.ExpenseGroup;
import com.design.backend.splitwise.model.Transaction;
import com.design.backend.splitwise.repository.ExpenseRepository;
import com.design.backend.splitwise.repository.GroupRepository;
import com.design.backend.splitwise.service.SettleUpService;
import com.design.backend.splitwise.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpServiceImpl implements SettleUpService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    @Autowired
    @Qualifier("HeapSettleUpStrategy")
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    SettleUpServiceImpl(
            GroupRepository groupRepository,
            ExpenseRepository expenseRepository
    ) {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Transaction> settleUpUser(
            Long userId
    ){
        // 1. check if user exists
        // 2. Corresponding to the user , get all the UserExpenses
        // 3. For all of these userExpenses get the expense detail
        // 4. use you algo on these expenses to settle your user
        // 5. once you get the transactions , you can filter out only those transactions which are associated to your user
        return null;
    }

    public List<Transaction> settleUpGroup(
            Long groupId
    ){
        // 1. check if group exists
        Optional<ExpenseGroup> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group not found");
        }
        ExpenseGroup group = groupOptional.get();
        // 2. if it exists, get all the expenses of the group
        List<Expense> expenses =  expenseRepository.findAllByGroup(group);
        // 3. use the algo to find the transactions
        // 4. return the transactions
        return settleUpStrategy.settleUp(expenses);

    }
}


// A : 500 , C : 500 , B : -1000
// Expense 1
// UserExpense 1 : User : A , amt : 500
// UserExpense 2 : User : B , amt : -1000
// UserExpense 3 : User : C , amt : 500


// B : 1500 , C : -500 , A : -1000
// Expense 2
// UserExpense 1 : User : A , amt : -1000
// UserExpense 2 : User : B , amt : 1500
// UserExpense 3 : User : C , amt : -500

// Create new group
// AddGroupMember
// AddExpense
//