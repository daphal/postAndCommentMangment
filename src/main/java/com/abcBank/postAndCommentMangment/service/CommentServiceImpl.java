package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepo commentRepo;
    @Override
    public BaseResponse<PostComment> saveCommentService(PostComment postComment) {
        PostComment reponse = commentRepo.save(postComment);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("200");
        baseResponse.setResponseObject(reponse);
        return baseResponse;
    }
}
