package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.*;
import com.abcBank.postAndCommentMangment.repository.DocumentPostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DocumentPostServiceImpl implements DocumentPostService {
    @Autowired
    DocumentPostRepositoryInterface documentPostRepositoryInterface;
    @Autowired
    RestTemplate restTemplate;
    String url="http://localhost:8022/document-service/v2/api/getUserByDocumentId/";
    @Override
    public BaseResponse<DocumentPost> savePost(DocumentPost documentPost) {
        BaseResponse<DocumentPost> documentPostBaseResponse = new BaseResponse<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        BaseResponse userDetails;
        HttpEntity response = new HttpEntity<>(httpHeaders);
        try {
        userDetails = restTemplate.exchange( url + documentPost.getDocument_Id(), HttpMethod.GET, response, new ParameterizedTypeReference<BaseResponse>() {
            }).getBody();
            String username = ((String) ((LinkedHashMap) userDetails.getResponseObject()).get("userName"));
            Integer user_Id = (Integer) ((LinkedHashMap) userDetails.getResponseObject()).get("user_Id");
            ArrayList<Document> documents = (ArrayList<Document>) ((LinkedHashMap) userDetails.getResponseObject()).get("documents");
            UserDetails newUserDetails = new UserDetails();
            newUserDetails.setUserName(username);
            newUserDetails.setUser_Id(user_Id);
            newUserDetails.setDocuments(documents);
            if (userDetails.getResponseObject() != null) {
                if (newUserDetails.getUser_Id() == documentPost.getUserId()) {
                    documentPost = documentPostRepositoryInterface.save(documentPost);
                    if (documentPost.getDocument_Id() > 0) {
                        documentPostBaseResponse.setResponseObject(documentPost);
                        documentPostBaseResponse.setReasonText("SUCCESS");
                        documentPostBaseResponse.setReasonCode("200");
                        documentPostBaseResponse.setStatus("OK");
                        documentPostBaseResponse.setReasonCode(CommonResponseData.SUCCESS);
                    } else {
                        documentPostBaseResponse.setReasonText("POST is not save");
                        documentPostBaseResponse.setReasonCode("500");
                        documentPostBaseResponse.setResponseObject(null);
                        documentPostBaseResponse.setStatus("Fail");
                        documentPostBaseResponse.setStatus(CommonResponseData.FAIL);
                    }
                } else {
                    documentPostBaseResponse.setReasonText("Your are not own this file");
                    documentPostBaseResponse.setReasonCode("403 ");
                    documentPostBaseResponse.setStatus("Fail");
                    documentPostBaseResponse.setResponseObject(null);
                    documentPostBaseResponse.setStatus(CommonResponseData.FAIL);
                }
            }
        } catch (Exception e) {
            documentPostBaseResponse.setReasonText(e.getMessage());
            documentPostBaseResponse.setReasonCode("500 ");
            documentPostBaseResponse.setStatus("Fail");
            documentPostBaseResponse.setResponseObject(null);
            documentPostBaseResponse.setStatus(CommonResponseData.FAIL);
        }
        return documentPostBaseResponse;
    }
    @Override
    public BaseResponse<PostInfo> getPostInfoByPostId(int id) {
        DocumentPost documentPost = null;
        BaseResponse userDetails = null;
        BaseResponse baseResponse = new BaseResponse();
        PostInfo postInfo = new PostInfo();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity response = new HttpEntity<org.springframework.http.ResponseEntity<BaseResponse<?>>>(httpHeaders);
        try {
            documentPost = documentPostRepositoryInterface.findById(id).get();
            userDetails = restTemplate.exchange(url + documentPost.getDocument_Id(), HttpMethod.GET, response, BaseResponse.class).getBody();
            String username = ((String) ((LinkedHashMap) userDetails.getResponseObject()).get("userName"));
            Integer user_Id = (Integer) ((LinkedHashMap) userDetails.getResponseObject()).get("user_Id");
            ArrayList<Document> documents = (ArrayList<Document>) ((LinkedHashMap) userDetails.getResponseObject()).get("documents");
            UserDetails newUserDetails = new UserDetails();
            newUserDetails.setUserName(username);
            newUserDetails.setUser_Id(user_Id);
            newUserDetails.setDocuments(documents);
            postInfo.setDocumentPost(documentPost);
            postInfo.setUserDetails(newUserDetails);
            baseResponse.setResponseObject(postInfo);
            baseResponse.setReasonCode("200");
            baseResponse.setReasonText(CommonResponseData.SUCCESS);
            baseResponse.setStatus(CommonResponseData.SUCCESS);
            return baseResponse;
        }
        catch (Exception e) {
            baseResponse.setResponseObject(null);
            baseResponse.setReasonCode("500");
            baseResponse.setReasonText(CommonResponseData.FAIL);
            baseResponse.setStatus(CommonResponseData.FAIL);
        }
        return baseResponse;
    }
    @Override
    public BaseResponse<DocumentPost> deletePost(Integer id) {
        BaseResponse<DocumentPost> response = new BaseResponse<>();
        try {
            DocumentPost documentPost = documentPostRepositoryInterface.findById(id).get();
            if (documentPost != null) {
                documentPostRepositoryInterface.delete(documentPost);
                response.setResponseObject(null);
                response.setReasonCode(CommonResponseData.SUCCESS);
                response.setStatus(CommonResponseData.SUCCESS);
                response.setReasonText("Post is deleted");
            } else {
                response.setReasonText("post is not found ");
                response.setReasonCode(CommonResponseData.FAIL);
                response.setStatus("Fail");
                response.setStatus(CommonResponseData.FAIL);
            }
        } catch (Exception ex) {
            response.setStatus(CommonResponseData.FAIL);
            response.setReasonText(ex.getMessage());
            response.setReasonCode(CommonResponseData.FAIL);
            response.setStatus("Fail");
            response.setResponseObject(null);
        }
        return response;
    }
}