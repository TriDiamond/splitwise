package com.design.backend.splitwise.repository;

import com.design.backend.splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {

    List<UserExpense> findByAllExpensesAndGroupAndUser();
}
