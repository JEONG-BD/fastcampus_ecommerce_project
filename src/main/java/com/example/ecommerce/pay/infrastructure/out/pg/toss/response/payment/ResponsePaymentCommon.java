package com.example.ecommerce.pay.infrastructure.out.pg.toss.response.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class ResponsePaymentCommon {
    private String orderid;
    private String paymentKey;
    private String method;
    private String status;
    private int totalAmount;
    private int balanceAmount;
}
