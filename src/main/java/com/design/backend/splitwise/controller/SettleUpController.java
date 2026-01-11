package com.design.backend.splitwise.controller;

import com.design.backend.splitwise.dto.ResponseStatus;
import com.design.backend.splitwise.dto.SettleUpRequest;
import com.design.backend.splitwise.dto.SettleUpResponse;
import com.design.backend.splitwise.impl.SettleUpServiceImpl;
import com.design.backend.splitwise.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpService settleUpService;

    public SettleUpResponse settleUp(SettleUpRequest request){
        SettleUpResponse response = new SettleUpResponse();
        try{
            settleUpService.settleUpGroup(request.getGroupName(), request.getUserName());
            settleUpService.settleUpUser(request.getGroupName(), request.getUserName());
        }catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Failure Message : "+ ex.getMessage());
        }
        return response;
    }
}
