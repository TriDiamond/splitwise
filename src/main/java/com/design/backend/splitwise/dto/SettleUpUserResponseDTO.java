package com.design.backend.splitwise.dto;

import com.design.backend.splitwise.model.Transaction;
import com.design.backend.splitwise.model.UserExpense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private ResponseStatus responseStatus;
    private List<Transaction> transactions;
}
