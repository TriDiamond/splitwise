package com.design.backend.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpRequest {
    private String groupName;
    private String userName;
}

/*
 * what are all the input needed for settle_up
 * 1) groupName
 * 2) userName
 */