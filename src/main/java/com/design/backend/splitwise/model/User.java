package com.design.backend.splitwise.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseModel {
    private String name;
    private String email;
    @ManyToMany(mappedBy =  "members")
    private List<ExpenseGroup> expenseGroup;
    @OneToMany(mappedBy = "user")
    private List<UserExpense> userExpenses;
}
