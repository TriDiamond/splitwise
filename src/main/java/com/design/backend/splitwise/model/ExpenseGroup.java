package com.design.backend.splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "expense_group")
public class ExpenseGroup extends BaseModel{
    private String groupName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
    @ManyToMany
    @JoinTable(name = "group_members")
    private List<User> members;
}
