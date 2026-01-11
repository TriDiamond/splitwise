package com.design.backend.splitwise.model;

import jakarta.persistence.*;

@Entity
@Table(name ="user_expense")
public class UserExpense extends BaseModel{
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
    @ManyToOne
    private Expense expense;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
