package com.ecommerce.ecommerce.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String last_update;

    public BaseResponse(){}

    public BaseResponse(T Data){
        this.data = data;
    }

    public BaseResponse(T data, String last_update){
        this.data = data;
        this.last_update= last_update;
    }
}
