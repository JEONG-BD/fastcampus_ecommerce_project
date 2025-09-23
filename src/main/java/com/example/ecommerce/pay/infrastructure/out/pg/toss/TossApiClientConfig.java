package com.example.ecommerce.pay.infrastructure.out.pg.toss;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@Slf4j
public class TossApiClientConfig {
    private static final String BASE_URL = "http://api.tosspayments.com/v1/";
    private static final String SECRET_KEY = "";


    public void init(){
        log.info("ApiClient Base URL: {}", BASE_URL);
        log.info("ApiClient Private Key: {}", SECRET_KEY);
    }
    
    public OkHttpClient okHttpClient(){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes =encoder.encode((SECRET_KEY + ":").getBytes(StandardCharsets.UTF_8));
        String authorization ="Basic " + new String(encodedBytes);
        log.info("key : {}", authorization);
        
        return new OkHttpClient().newBuilder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(chain ->  {
                Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", authorization)
                .build();
                return chain.proceed(request);
            }).build();
        }
        

    @Bean
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(okHttpClient)
                .build();
    }

    

}
