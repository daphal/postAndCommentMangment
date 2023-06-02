package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommonResponseData;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/saveComment")
    public ResponseEntity<BaseResponse<?>> saveComments(@RequestBody PostComment postComment) {
        BaseResponse<PostComment> baseResponse = commentService.saveCommentService(postComment);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
    @PatchMapping("/updateComment")
    public ResponseEntity<BaseResponse<?>> updateComment(@RequestBody PostComment postComment) {
        BaseResponse<PostComment> baseResponse = commentService.saveCommentService(postComment);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
    @DeleteMapping("/deletePostComment/{id}")
    public ResponseEntity<BaseResponse<?>> deletePostComment(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        BaseResponse<PostComment> baseResponse = commentService.deleteComment(id);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
}
