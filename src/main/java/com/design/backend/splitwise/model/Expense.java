package com.design.backend.splitwise.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense")
public class Expense extends BaseModel {
    private String title; // "Movie", "Dinner"
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private SplitOptions splitOptions;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ExpenseGroup group;

    @ManyToOne
    @JoinColumn(name = "paid_by_id")
    private User paidBy; // who actually paid
}
