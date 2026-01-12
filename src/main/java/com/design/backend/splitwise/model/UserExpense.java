package com.design.backend.splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="user_expense")
public class UserExpense extends BaseModel{
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
    @ManyToOne
    private Expense expense;
    private int amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
