package com.design.backend.splitwise.service;

import com.design.backend.splitwise.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettleUpService {

    List<Transaction> settleUpGroup(Long groupId);

    List<Transaction> settleUpUser(Long userId);
}
