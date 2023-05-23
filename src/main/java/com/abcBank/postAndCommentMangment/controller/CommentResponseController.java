package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentResponseController {

    @Autowired
    CommentResponseService commentResponseService;

    @PostMapping("/saveCommentResponse")
    public ResponseEntity<BaseResponse<?>> saveCommentsResponse(@RequestBody CommentResponse commentResponse)
    {
        BaseResponse<CommentResponse> baseResponse= commentResponseService.saveCommenResponseService(commentResponse);
        return new ResponseEntity<BaseResponse<?>>(baseResponse,null, HttpStatus.ACCEPTED);
    }
}
