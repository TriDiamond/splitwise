package com.design.backend.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "expense_group")
public class ExpenseGroup extends BaseModel{
    private String groupName;

    @ManyToMany
    private List<User> members;
}
