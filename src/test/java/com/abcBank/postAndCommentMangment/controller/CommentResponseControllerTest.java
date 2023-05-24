package com.abcBank.postAndCommentMangment.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.service.CommentResponseService;
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

@ContextConfiguration(classes = {CommentResponseController.class})
@ExtendWith(SpringExtension.class)
class CommentResponseControllerTest {
    @Autowired
    private CommentResponseController commentResponseController;

    @MockBean
    private CommentResponseService commentResponseService;


    @Test
    void testDeleteCommentResponse() throws Exception {
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

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentResponse("Comment Response");
        commentResponse.setComment_Response_ID(1);
        commentResponse.setPostComment(postComment);

        BaseResponse<CommentResponse> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(commentResponse);
        baseResponse.setStatus("Status");
        when(commentResponseService.deleteComment((Integer) any())).thenReturn(baseResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/api/deleteCommentResponse/{id}",
                1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentResponseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Response_ID\":1,\"commentResponse\":\"Comment Response\"},\"responseListObject\":[]}"));
    }


    @Test
    void testSaveCommentsResponse() throws Exception {
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

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentResponse("Comment Response");
        commentResponse.setComment_Response_ID(1);
        commentResponse.setPostComment(postComment);

        BaseResponse<CommentResponse> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(commentResponse);
        baseResponse.setStatus("Status");
        when(commentResponseService.saveCommenResponseService((CommentResponse) any())).thenReturn(baseResponse);

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

        CommentResponse commentResponse1 = new CommentResponse();
        commentResponse1.setCommentResponse("Comment Response");
        commentResponse1.setComment_Response_ID(1);
        commentResponse1.setPostComment(postComment1);
        String content = (new ObjectMapper()).writeValueAsString(commentResponse1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/api/saveCommentResponse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentResponseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Response_ID\":1,\"commentResponse\":\"Comment Response\"},\"responseListObject\":[]}"));
    }


    @Test
    void testUpdateCommentResponse() throws Exception {
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

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentResponse("Comment Response");
        commentResponse.setComment_Response_ID(1);
        commentResponse.setPostComment(postComment);

        BaseResponse<CommentResponse> baseResponse = new BaseResponse<>();
        baseResponse.setReasonCode("Just cause");
        baseResponse.setReasonText("Just cause");
        baseResponse.setResponseListObject(new ArrayList<>());
        baseResponse.setResponseObject(commentResponse);
        baseResponse.setStatus("Status");
        when(commentResponseService.saveCommenResponseService((CommentResponse) any())).thenReturn(baseResponse);

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

        CommentResponse commentResponse1 = new CommentResponse();
        commentResponse1.setCommentResponse("Comment Response");
        commentResponse1.setComment_Response_ID(1);
        commentResponse1.setPostComment(postComment1);
        String content = (new ObjectMapper()).writeValueAsString(commentResponse1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/v1/api/updateCommentResponse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentResponseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Status\",\"reasonCode\":\"Just cause\",\"reasonText\":\"Just cause\",\"responseObject\":{\"comment"
                                        + "_Response_ID\":1,\"commentResponse\":\"Comment Response\"},\"responseListObject\":[]}"));
    }
}

