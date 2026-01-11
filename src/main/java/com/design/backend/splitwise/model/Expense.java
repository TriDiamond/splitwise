package com.design.backend.splitwise.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "expense")
public class Expense extends BaseModel {
    private String description;
    private double totalAmount;
    private Date expenseDate;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidByUsers;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidForUsers;
    @ManyToOne
    private ExpenseGroup group;
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;
}
