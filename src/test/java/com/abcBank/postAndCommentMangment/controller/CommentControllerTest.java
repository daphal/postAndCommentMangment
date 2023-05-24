package com.abcBank.postAndCommentMangment.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentService;
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

@ContextConfiguration(classes = {CommentController.class})
@ExtendWith(SpringExtension.class)
class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    @MockBean
    private CommentService commentService;


    @Test
    void testDeletePostComment() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        PostComment postComment = new PostComment();
        postComment.setCommentMessage("Comment Message");
        postComment.setCommentResponseLis(new ArrayList<>());
        postComment.setComment_Id(123);
        postComment.setDocumentPost(documentPost);
        postComment.setUserId(123);

        BaseResponse<PostComment> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(postComment);
        baseResponse.setStatus("Status");
        when(commentService.deleteComment((Integer) any())).thenReturn(baseResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/api/deletePostComment/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Id\":123,\"commentMessage\":\"Comment Message\",\"commentResponseLis\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }


    @Test
    void testSaveComments() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        PostComment postComment = new PostComment();
        postComment.setCommentMessage("Comment Message");
        postComment.setCommentResponseLis(new ArrayList<>());
        postComment.setComment_Id(123);
        postComment.setDocumentPost(documentPost);
        postComment.setUserId(123);

        BaseResponse<PostComment> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(postComment);
        baseResponse.setStatus("Status");
        when(commentService.saveCommentService((PostComment) any())).thenReturn(baseResponse);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);

        PostComment postComment1 = new PostComment();
        postComment1.setCommentMessage("Comment Message");
        postComment1.setCommentResponseLis(new ArrayList<>());
        postComment1.setComment_Id(123);
        postComment1.setDocumentPost(documentPost1);
        postComment1.setUserId(123);
        String content = (new ObjectMapper()).writeValueAsString(postComment1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/saveComment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Id\":123,\"commentMessage\":\"Comment Message\",\"commentResponseLis\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }


    @Test
    void testUpdateComment() throws Exception {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);

        PostComment postComment = new PostComment();
        postComment.setCommentMessage("Comment Message");
        postComment.setCommentResponseLis(new ArrayList<>());
        postComment.setComment_Id(123);
        postComment.setDocumentPost(documentPost);
        postComment.setUserId(123);

        BaseResponse<PostComment> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(postComment);
        baseResponse.setStatus("Status");
        when(commentService.saveCommentService((PostComment) any())).thenReturn(baseResponse);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);

        PostComment postComment1 = new PostComment();
        postComment1.setCommentMessage("Comment Message");
        postComment1.setCommentResponseLis(new ArrayList<>());
        postComment1.setComment_Id(123);
        postComment1.setDocumentPost(documentPost1);
        postComment1.setUserId(123);
        String content = (new ObjectMapper()).writeValueAsString(postComment1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/v1/api/updateComment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Id\":123,\"commentMessage\":\"Comment Message\",\"commentResponseLis\":[],\"userId\":123},\"responseListObject"
                                        + "\":[]}"));
    }
}

