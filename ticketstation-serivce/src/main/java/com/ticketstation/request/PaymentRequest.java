package com.ticketstation.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private int userId;
    private String cardNumber;
    private String cvv;
    private String accountNumber;
    private Double balance;

}
