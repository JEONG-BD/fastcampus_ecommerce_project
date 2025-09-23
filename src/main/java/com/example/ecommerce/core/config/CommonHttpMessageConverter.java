package com.example.ecommerce.core.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import com.example.ecommerce.core.common.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)

public class CommonHttpMessageConverter extends AbstractHttpMessageConverter<ApiResponse<Object>>{

    private final ObjectMapper objectMapper;

    public CommonHttpMessageConverter(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(){
        return Collections.singletonList(MediaType.APPLICATION_JSON);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.equals(ApiResponse.class) || clazz.isPrimitive()||clazz.equals(String.class);
    }

    @Override
    protected ApiResponse<Object> readInternal(Class<? extends ApiResponse<Object>> clazz,
            HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        throw new UnsupportedOperationException("this converter can only writing support operation");
    }

    @Override
    protected void writeInternal(ApiResponse<Object> objectApiResponse, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException{
        String responseMessage = this.objectMapper.writeValueAsString(objectApiResponse);
        StreamUtils.copy(responseMessage.getBytes(StandardCharsets.UTF_8), outputMessage.getBody());
    }
  
}
