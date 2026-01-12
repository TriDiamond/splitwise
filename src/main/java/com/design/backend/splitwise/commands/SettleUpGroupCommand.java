package com.design.backend.splitwise.commands;

import com.design.backend.splitwise.controller.SettleUpController;
import com.design.backend.splitwise.dto.ResponseStatus;
import com.design.backend.splitwise.dto.SettleUpGroupRequestDTO;
import com.design.backend.splitwise.dto.SettleUpGroupResponseDTO;
import com.design.backend.splitwise.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUpGroupCommand implements Command{
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean match(String input) {
        // Command should look like this : "SettleUpGroup 1"
        List<String> words =  List.of(input.split(" "));
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words =  List.of(input.split(" "));
        Long groupId = Long.valueOf(words.get(1));

        SettleUpGroupRequestDTO request = new SettleUpGroupRequestDTO();
        request.setGroupId(groupId);

        SettleUpGroupResponseDTO responseDTO = settleUpController.settleUpGroup(request);
        System.out.println(responseDTO.getResponseStatus());
        if(responseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDTO.getFailureMessage());
        } else {
            for(Transaction transaction : responseDTO.getTransactions()){
                System.out.println(transaction.getUserFrom().getName() + " should pay " + transaction.getUserTo().getName() + " : " + transaction.getAmount());
            }
        }
    }
}