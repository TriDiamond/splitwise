package com.design.backend.splitwise.controller;

import com.design.backend.splitwise.dto.*;
import com.design.backend.splitwise.model.Transaction;
import com.design.backend.splitwise.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    SettleUpService settleUpService;
    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO request){
        SettleUpUserResponseDTO response = new SettleUpUserResponseDTO();
        try{
            List<Transaction> transactions = settleUpService.settleUpUser(request.getUserId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO request){
        SettleUpGroupResponseDTO response = new SettleUpGroupResponseDTO();
        try{
            List<Transaction> transactions = settleUpService.settleUpGroup(request.getGroupId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(ex.getMessage());
        }
        return response;
    }
}