package com.abcBank.postAndCommentMangment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostInfo;
import com.abcBank.postAndCommentMangment.model.UserDetails;
import com.abcBank.postAndCommentMangment.repository.DocumentPostRepositoryInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.h2.util.SmallLRUCache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {DocumentPostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DocumentPostServiceImplTest {
    @MockBean
    private DocumentPostRepositoryInterface documentPostRepositoryInterface;

    @Autowired
    private DocumentPostServiceImpl documentPostServiceImpl;

    @MockBean
    private RestTemplate restTemplate;


    @Test
    void testSavePost() throws RestClientException {
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        BaseResponse<DocumentPost> actualSavePostResult = documentPostServiceImpl.savePost(documentPost);
        assertEquals("500 ", actualSavePostResult.getReasonCode());
        assertEquals("fail", actualSavePostResult.getStatus());
        assertNull(actualSavePostResult.getResponseObject());
        assertNull(actualSavePostResult.getReasonText());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any());
    }


    @Test
    void testSavePost2() throws RestClientException {
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any())).thenReturn(null);

        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        BaseResponse<DocumentPost> actualSavePostResult = documentPostServiceImpl.savePost(documentPost);
        assertEquals("500 ", actualSavePostResult.getReasonCode());
        assertEquals("fail", actualSavePostResult.getStatus());
        assertNull(actualSavePostResult.getResponseObject());
        assertNull(actualSavePostResult.getReasonText());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any());
    }


    @Test
    void testSavePost3() throws RestClientException {
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any()))
                .thenReturn(new ResponseEntity<>("Body", HttpStatus.CONTINUE));

        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        BaseResponse<DocumentPost> actualSavePostResult = documentPostServiceImpl.savePost(documentPost);
        assertEquals("500 ", actualSavePostResult.getReasonCode());
        assertEquals("fail", actualSavePostResult.getStatus());
        assertNull(actualSavePostResult.getResponseObject());
        assertEquals(
                "class java.lang.String cannot be cast to class com.abcBank.postAndCommentMangment.model.BaseResponse"
                        + " (java.lang.String is in module java.base of loader 'bootstrap'; com.abcBank.postAndCommentMangment"
                        + ".model.BaseResponse is in unnamed module of loader com.diffblue.cover.f.g @2bd8263a)",
                actualSavePostResult.getReasonText());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any());
    }


    @Test
    void testSavePost4() throws RestClientException {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject("Response Object");
        baseResponse.setStatus("500 ");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(baseResponse, HttpStatus.CONTINUE);

        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any())).thenReturn(responseEntity);

        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        BaseResponse<DocumentPost> actualSavePostResult = documentPostServiceImpl.savePost(documentPost);
        assertEquals("500 ", actualSavePostResult.getReasonCode());
        assertEquals("fail", actualSavePostResult.getStatus());
        assertNull(actualSavePostResult.getResponseObject());
        assertEquals(
                "class java.lang.String cannot be cast to class java.util.LinkedHashMap (java.lang.String and"
                        + " java.util.LinkedHashMap are in module java.base of loader 'bootstrap')",
                actualSavePostResult.getReasonText());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (ParameterizedTypeReference<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId2() throws RestClientException {
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(Optional.empty());
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
    }


    @Test
    void testGetPostInfoByPostId3() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(null);
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId4() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(new ResponseEntity<>("Body", HttpStatus.CONTINUE));
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId5() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject("Response Object");
        baseResponse.setStatus("500");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(baseResponse, HttpStatus.CONTINUE);

        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(responseEntity);
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId6() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(new ResponseEntity<>(new BaseResponse<>(), HttpStatus.CONTINUE));
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId7() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(new LinkedHashMap<>());
        baseResponse.setStatus("500");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(baseResponse, HttpStatus.CONTINUE);

        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(responseEntity);
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("200", actualPostInfoByPostId.getReasonCode());
        assertEquals("success", actualPostInfoByPostId.getStatus());
        assertEquals("success", actualPostInfoByPostId.getReasonText());
        PostInfo responseObject = actualPostInfoByPostId.getResponseObject();
        assertSame(documentPost, responseObject.getDocumentPost());
        UserDetails userDetails = responseObject.getUserDetails();
        assertNull(userDetails.getUser_Id());
        assertNull(userDetails.getUserName());
        assertNull(userDetails.getDocuments());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
    }


    @Test
    void testGetPostInfoByPostId8() throws RestClientException {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        SmallLRUCache<Object, Object> objectObjectMap = (SmallLRUCache<Object, Object>) mock(SmallLRUCache.class);
        when(objectObjectMap.get((Object) any())).thenReturn("Get");

        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(objectObjectMap);
        baseResponse.setStatus("500");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(baseResponse, HttpStatus.CONTINUE);

        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(responseEntity);
        BaseResponse<PostInfo> actualPostInfoByPostId = documentPostServiceImpl.getPostInfoByPostId(1);
        assertEquals("500", actualPostInfoByPostId.getReasonCode());
        assertEquals("fail", actualPostInfoByPostId.getStatus());
        assertNull(actualPostInfoByPostId.getResponseObject());
        assertEquals("fail", actualPostInfoByPostId.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(),
                (Class<Object>) any(), (Object[]) any());
        verify(objectObjectMap, atLeast(1)).get((Object) any());
    }


    @Test
    void testDeletePost() {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost);
        doNothing().when(documentPostRepositoryInterface).delete((DocumentPost) any());
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        BaseResponse<DocumentPost> actualDeletePostResult = documentPostServiceImpl.deletePost(1);
        assertEquals("success", actualDeletePostResult.getReasonCode());
        assertEquals("success", actualDeletePostResult.getStatus());
        assertNull(actualDeletePostResult.getResponseObject());
        assertEquals("Post is deleted", actualDeletePostResult.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
        verify(documentPostRepositoryInterface).delete((DocumentPost) any());
    }

    @Test
    void testDeletePost2() {
        doNothing().when(documentPostRepositoryInterface).delete((DocumentPost) any());
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(null);
        BaseResponse<DocumentPost> actualDeletePostResult = documentPostServiceImpl.deletePost(1);
        assertEquals("fail", actualDeletePostResult.getReasonCode());
        assertEquals("Fail", actualDeletePostResult.getStatus());
        assertNull(actualDeletePostResult.getResponseObject());
        assertNull(actualDeletePostResult.getReasonText());
        verify(documentPostRepositoryInterface).findById((Integer) any());
    }
}

