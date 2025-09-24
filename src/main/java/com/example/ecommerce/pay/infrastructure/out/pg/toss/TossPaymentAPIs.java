package com.example.ecommerce.pay.infrastructure.out.pg.toss;

import com.example.ecommerce.pay.infrastructure.out.pg.toss.response.ResponsePaymentSettlements;
import com.example.ecommerce.pay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import com.example.ecommerce.pay.infrastructure.out.pg.toss.response.ResponsePaymentCancel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface TossPaymentAPIs {
    @POST("payments/confirm")
    Call<ResponsePaymentApproved> paymentFullfill(@Body ResponsePaymentApproved request);

    //@POST("payments/{paymentKey}/cancel")
    //Call<ResponsePaymentCancel> paymentCancel(@Path("paymentKey") String paymentKey, @Body PaymentCancel requestMessage);

    @GET("settlements")
    Call<List<ResponsePaymentSettlements>> paymentSettlements(@Path("startDate") String startDate,
                                                              @Path("endDate") String endDate,
                                                              @Path("page") int page,
                                                              @Path("size") int size);
}
