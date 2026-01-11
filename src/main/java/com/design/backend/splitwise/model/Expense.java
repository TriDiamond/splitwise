package com.design.backend.splitwise.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "expense")
public class Expense extends BaseModel {
    private String description;
    private double totalAmount;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> whoPaid;
    @ManyToOne
    private ExpenseGroup group;
}
