package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostInfo;
import com.abcBank.postAndCommentMangment.service.DocumentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin("*")
public class DocmentPostController {
    @Autowired
    DocumentPostService documentPostService;
    @PostMapping("/createPost")
    public ResponseEntity<BaseResponse<?>> createPost(@RequestBody DocumentPost documentPost, HttpServletRequest request) throws Exception {
        BaseResponse<DocumentPost> basedocumentPost = documentPostService.savePost(documentPost);
        ResponseEntity responseEntity = new ResponseEntity<>(basedocumentPost, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @PatchMapping("/updatePost")
    public ResponseEntity<BaseResponse<?>> updatePost(@RequestBody DocumentPost documentPost, HttpServletRequest request) throws Exception {
        BaseResponse<DocumentPost> basedocumentPost = documentPostService.savePost(documentPost);
        ResponseEntity responseEntity = new ResponseEntity<>(basedocumentPost, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<BaseResponse<?>> deletePost(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        BaseResponse<DocumentPost> basedocumentPost = documentPostService.deletePost(id);
        ResponseEntity responseEntity = new ResponseEntity<>(basedocumentPost, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @GetMapping("/getInfoByPost/{id}")
    public ResponseEntity<BaseResponse<?>> getPostInfoById(@PathVariable int id) {
        BaseResponse<PostInfo> baseResponse = documentPostService.getPostInfoByPostId(id);
        ResponseEntity responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        return responseEntity;
    }
}