package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.*;
import com.abcBank.postAndCommentMangment.repository.CommentRepo;
import com.abcBank.postAndCommentMangment.repository.CommentResponseRepo;
import com.abcBank.postAndCommentMangment.repository.DocumentPostRepositoryInterface;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
@Service
public class DocumentPostServiceImpl implements DocumentPostService {

    @Autowired
    DocumentPostRepositoryInterface documentPostRepositoryInterface;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentResponseRepo commentResponseRepo;

    @Autowired
    CommentRepo commentRepo;

    @Override
    public BaseResponse<DocumentPost> savePost(DocumentPost documentPost) {
        BaseResponse<DocumentPost> documentPostBaseResponse = new BaseResponse<>();
        //TODO:call document API of get
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        BaseResponse<Document> documentBaseResponse;
        HttpEntity response = new HttpEntity<org.springframework.http.ResponseEntity<BaseResponse<?>>>(httpHeaders);
        /*try {

            documentBaseResponse = restTemplate.exchange("http://localhost:8081/v1/api/getDocument/" + documentPost.getDocument_Id(), HttpMethod.GET, response, BaseResponse.class).getBody();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/


        documentPost = documentPostRepositoryInterface.save(documentPost);
        if (documentPost.getId() > 0) {
            documentPostBaseResponse.setResponseObject(documentPost);
            documentPostBaseResponse.setReasonText("Save");
            documentPostBaseResponse.setReasonCode("200");
            documentPostBaseResponse.setReasonCode(CommonResponseData.SUCCESS);
        } else {
            documentPostBaseResponse.setReasonText("error");
            documentPostBaseResponse.setReasonCode("500");
            documentPostBaseResponse.setStatus(CommonResponseData.FAIL);
        }
        return documentPostBaseResponse;
    }

    @Override
    public BaseResponse<PostInfo> getPostInfoByPostId(int id) {
        DocumentPost documentPost = null;
        PostComment postComment = null;

        BaseResponse baseResponse = new BaseResponse();
        BaseResponse<PostInfo> documentPostBaseResponse = new BaseResponse<>();
        try {
            //fetch document data
            documentPost = documentPostRepositoryInterface.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO:call document API of get
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        BaseResponse<UserDetails> userDetailsBaseResponse;
        HttpEntity  response=new HttpEntity<org.springframework.http.ResponseEntity<BaseResponse<?>>>(httpHeaders);
        try {
            userDetailsBaseResponse = restTemplate.exchange("localhost:8081/v2/api/getUserByDocumentId" +id, HttpMethod.GET, response, BaseResponse.class).getBody();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        baseResponse.setReasonCode("200");
        PostInfo postInfo = new PostInfo();
        postInfo.setDocumentPost(documentPost);
        baseResponse.setResponseObject(postInfo);
        return baseResponse;
    }
}
