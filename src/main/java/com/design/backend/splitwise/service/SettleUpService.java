package com.design.backend.splitwise.service;

public interface SettleUpService {

    void settleUpGroup(String groupName, String userName);

    void settleUpUser(String groupName, String userName);
}
