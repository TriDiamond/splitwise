package com.design.backend.splitwise.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_split")
public class ExpenseSplit extends BaseModel{
        @ManyToOne
        @JoinColumn(name = "expense_id")
        private Expense expense;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private double amount;

        @Enumerated(EnumType.STRING)
        private SplitPaymentStatus status;
}
