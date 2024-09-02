package com.member_level.member_level.dto.request;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class TransactionMessage {
    private Double grandTotal;
    private String cardNumber;

}
