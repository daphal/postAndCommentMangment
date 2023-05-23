package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.repository.CommentResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentResponseServiceImpl implements CommentResponseService{

    @Autowired
    CommentResponseRepo commentResponseRepo;
    @Override
    public BaseResponse<CommentResponse> saveCommenResponseService(CommentResponse commentResponse) {

        BaseResponse<CommentResponse> baseResponse=new BaseResponse<>();
        CommentResponse commentResponse1=commentResponseRepo.save(commentResponse);
        baseResponse.setResponseObject(commentResponse1);
        baseResponse.setStatus("Accepted");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }
}
