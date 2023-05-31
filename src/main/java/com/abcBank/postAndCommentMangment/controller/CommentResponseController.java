package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin("*")
public class CommentResponseController {
    @Autowired
    CommentResponseService commentResponseService;
    @PostMapping("/saveCommentResponse")
    public ResponseEntity<BaseResponse<?>> saveCommentsResponse(@RequestBody CommentResponse commentResponse) {
        BaseResponse<CommentResponse> baseResponse = commentResponseService.saveCommenResponseService(commentResponse);
        return new ResponseEntity<BaseResponse<?>>(baseResponse, null, HttpStatus.ACCEPTED);
    }
    @PatchMapping("/updateCommentResponse")
    public ResponseEntity<BaseResponse<?>> updateCommentResponse(@RequestBody CommentResponse commentResponse) {
        BaseResponse<CommentResponse> baseResponse = commentResponseService.saveCommenResponseService(commentResponse);
        return new ResponseEntity<BaseResponse<?>>(baseResponse, null, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteCommentResponse/{id}")
    public ResponseEntity<BaseResponse<?>> deleteCommentResponse(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        BaseResponse<CommentResponse> baseResponse = commentResponseService.deleteComment(id);
        ResponseEntity responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
