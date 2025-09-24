package com.example.ecommerce.pay.infrastructure.out.pg.toss.response.payment.method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private String issuerCode;
    private String acquirerCode;
    private String number;
    private String cardType;
    private String acquireStatus;
    private String approveNo;
    private int amount;
    private boolean isInterestFree;
    private String receiptUrl;


}
