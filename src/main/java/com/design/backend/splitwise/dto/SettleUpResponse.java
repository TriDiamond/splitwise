package com.design.backend.splitwise.dto;

import com.design.backend.splitwise.model.User;
import com.design.backend.splitwise.model.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponse {
    private List<UserExpense> paidBy;
    private String message;
    private ResponseStatus responseStatus;
}
