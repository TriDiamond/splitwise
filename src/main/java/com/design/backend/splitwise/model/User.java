package com.design.backend.splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    @ManyToMany(mappedBy =  "members")
    private List<ExpenseGroup> expenseGroup;
    @OneToMany(mappedBy = "user")
    private List<UserExpense> userExpenses;
}
