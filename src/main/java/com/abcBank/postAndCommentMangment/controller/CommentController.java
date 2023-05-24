package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
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
        return new ResponseEntity<BaseResponse<?>>(baseResponse, null, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateComment")
    public ResponseEntity<BaseResponse<?>> updateComment(@RequestBody PostComment postComment) {
        BaseResponse<PostComment> baseResponse = commentService.saveCommentService(postComment);
        return new ResponseEntity<BaseResponse<?>>(baseResponse, null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deletePostComment/{id}")
    public ResponseEntity<BaseResponse<?>> deletePostComment(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        BaseResponse<PostComment> baseResponse = commentService.deleteComment(id);
        ResponseEntity responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }

}
