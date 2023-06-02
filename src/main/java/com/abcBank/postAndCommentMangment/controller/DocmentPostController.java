package com.abcBank.postAndCommentMangment.controller;

import com.abcBank.postAndCommentMangment.model.*;
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
        BaseResponse<DocumentPost> baseResponse = documentPostService.savePost(documentPost);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
    @PatchMapping("/updatePost")
    public ResponseEntity<BaseResponse<?>> updatePost(@RequestBody DocumentPost documentPost, HttpServletRequest request) throws Exception {
        BaseResponse<DocumentPost> baseResponse = documentPostService.savePost(documentPost);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<BaseResponse<?>> deletePost(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        BaseResponse<DocumentPost> baseResponse = documentPostService.deletePost(id);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
    @GetMapping("/getInfoByPost/{id}")
    public ResponseEntity<BaseResponse<?>> getPostInfoById(@PathVariable int id) {
        BaseResponse<PostInfo> baseResponse = documentPostService.getPostInfoByPostId(id);
        ResponseEntity responseEntity;
        if(baseResponse.getStatus().equals(CommonResponseData.SUCCESS)) {
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<>(baseResponse, null, HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }

    @PostMapping("/savePost")
    public ResponseEntity<BaseResponse<?>> savePost(@RequestBody PostInfoSave postInfo, HttpServletRequest request) throws Exception {
        BaseResponse<PostInfoSave>  baseResponse = documentPostService.savePost1(postInfo);
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