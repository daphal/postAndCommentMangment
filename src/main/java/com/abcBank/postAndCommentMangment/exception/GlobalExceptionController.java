package com.abcBank.postAndCommentMangment.exception;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommonResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
    BaseResponse response = new BaseResponse<>();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<?>> unknowException(Exception exception){
        response.setStatus(CommonResponseData.FAIL);
        response.setReasonCode(CommonResponseData.FAIL);
        response.setReasonText(exception.getMessage());
        response.setResponseObject(null);
        ResponseEntity responseEntity = new ResponseEntity<>(response, null, HttpStatus.EXPECTATION_FAILED);
        return  responseEntity;
    }

}
