package com.example.ecommerce.pay.infrastructure.out.pg.toss.response;

import com.example.ecommerce.pay.infrastructure.out.pg.toss.response.payment.method.Card;

public class ResponsePaymentApproved {

    private String orderName;
    private Card card;
    private String lastTransactionKey;
    private int suppliedAmount;
    private int vat;
    private String requestAt;
    private String approvedAt;


}
