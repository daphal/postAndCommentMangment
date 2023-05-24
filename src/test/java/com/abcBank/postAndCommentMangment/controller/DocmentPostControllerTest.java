package com.abcBank.postAndCommentMangment.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostInfo;
import com.abcBank.postAndCommentMangment.model.UserDetails;
import com.abcBank.postAndCommentMangment.service.DocumentPostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DocmentPostController.class})
@ExtendWith(SpringExtension.class)
class DocmentPostControllerTest {
    @Autowired
    private DocmentPostController docmentPostController;

    @MockBean
    private DocumentPostService documentPostService;


    @Test
    void testCreatePost() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        BaseResponse<DocumentPost> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(documentPost);
        baseResponse.setStatus("Status");
        when(documentPostService.savePost((DocumentPost) any())).thenReturn(baseResponse);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);
        String content = (new ObjectMapper()).writeValueAsString(documentPost1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/createPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(docmentPostController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"post_Id\""
                                        + ":123,\"document_Id\":123,\"postMessage\":\"Post Message\",\"postComments\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }


    @Test
    void testDeletePost() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        BaseResponse<DocumentPost> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(documentPost);
        baseResponse.setStatus("Status");
        when(documentPostService.deletePost((Integer) any())).thenReturn(baseResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/api/deletePost/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(docmentPostController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"post_Id\""
                                        + ":123,\"document_Id\":123,\"postMessage\":\"Post Message\",\"postComments\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }


    @Test
    void testGetPostInfoById() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        PostInfo postInfo = new PostInfo();
        postInfo.setDocumentPost(documentPost);
        postInfo.setUserDetails(new UserDetails());

        BaseResponse<PostInfo> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(postInfo);
        baseResponse.setStatus("Status");
        when(documentPostService.getPostInfoByPostId(anyInt())).thenReturn(baseResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/getInfoByPost/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(docmentPostController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"documentPost"
                                        + "\":{\"post_Id\":123,\"document_Id\":123,\"postMessage\":\"Post Message\",\"postComments\":[],\"userId\":123},"
                                        + "\"userDetails\":{\"user_Id\":null,\"userName\":null}},\"responseListObject\":[]}"));
    }


    @Test
    void testUpdatePost() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        BaseResponse<DocumentPost> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(documentPost);
        baseResponse.setStatus("Status");
        when(documentPostService.savePost((DocumentPost) any())).thenReturn(baseResponse);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);
        String content = (new ObjectMapper()).writeValueAsString(documentPost1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/v1/api/updatePost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(docmentPostController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"post_Id\""
                                        + ":123,\"document_Id\":123,\"postMessage\":\"Post Message\",\"postComments\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }
}

