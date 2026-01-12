package com.design.backend.splitwise.repository;

import com.design.backend.splitwise.model.Expense;
import com.design.backend.splitwise.model.ExpenseGroup;
import com.design.backend.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(ExpenseGroup group);
}

