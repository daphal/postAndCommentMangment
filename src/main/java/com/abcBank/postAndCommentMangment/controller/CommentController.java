package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/saveComment")
    public ResponseEntity<BaseResponse<?>> saveComments(@RequestBody PostComment postComment)
    {
        BaseResponse<PostComment> baseResponse= commentService.saveCommentService(postComment);
        return new ResponseEntity<BaseResponse<?>>(baseResponse,null, HttpStatus.ACCEPTED);
    }

}
