package com.design.backend.splitwise.dto;

import com.design.backend.splitwise.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {
    private ResponseStatus responseStatus;
    private String failureMessage;
    private List<Transaction> transactions;

}