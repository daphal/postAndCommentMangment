package com.abcBank.postAndCommentMangment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.repository.CommentRepositoryInterface;
import com.abcBank.postAndCommentMangment.repository.CommentResponseRepositoryInterface;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CommentResponseServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CommentResponseServiceImplTest {
    @MockBean
    private CommentRepositoryInterface commentRepositoryInterface;

    @MockBean
    private CommentResponseRepositoryInterface commentResponseRepositoryInterface;

    @Autowired
    private CommentResponseServiceImpl commentResponseServiceImpl;


    @Test
    void testSaveCommenResponseService() {
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
        Optional<PostComment> ofResult = Optional.of(postComment);
        when(commentRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

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

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentResponse("Comment Response");
        commentResponse.setComment_Response_ID(1);
        commentResponse.setPostComment(postComment1);
        when(commentResponseRepositoryInterface.save((CommentResponse) any())).thenReturn(commentResponse);

        DocumentPost documentPost2 = new DocumentPost();
        documentPost2.setDocument_Id(123);
        documentPost2.setPostComments(new ArrayList<>());
        documentPost2.setPostMessage("Post Message");
        documentPost2.setPost_Id(123);
        documentPost2.setUserId(123);

        PostComment postComment2 = new PostComment();
        postComment2.setCommentMessage("Comment Message");
        postComment2.setCommentResponseLis(new ArrayList<>());
        postComment2.setComment_Id(123);
        postComment2.setDocumentPost(documentPost2);
        postComment2.setUserId(123);

        CommentResponse commentResponse1 = new CommentResponse();
        commentResponse1.setCommentResponse("Comment Response");
        commentResponse1.setComment_Response_ID(1);
        commentResponse1.setPostComment(postComment2);
        BaseResponse<CommentResponse> actualSaveCommenResponseServiceResult = commentResponseServiceImpl
                .saveCommenResponseService(commentResponse1);
        assertEquals("200", actualSaveCommenResponseServiceResult.getReasonCode());
        assertEquals("success", actualSaveCommenResponseServiceResult.getStatus());
        assertSame(commentResponse, actualSaveCommenResponseServiceResult.getResponseObject());
        assertEquals("success", actualSaveCommenResponseServiceResult.getReasonText());
        verify(commentRepositoryInterface).findById((Integer) any());
        verify(commentResponseRepositoryInterface).save((CommentResponse) any());
    }


    @Test
    void testSaveCommenResponseService3() {
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
        Optional<PostComment> ofResult = Optional.of(postComment);
        when(commentRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

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
        CommentResponse commentResponse = mock(CommentResponse.class);
        when(commentResponse.getComment_Response_ID()).thenReturn(-1);
        doNothing().when(commentResponse).setCommentResponse((String) any());
        doNothing().when(commentResponse).setComment_Response_ID((Integer) any());
        doNothing().when(commentResponse).setPostComment((PostComment) any());
        commentResponse.setCommentResponse("Comment Response");
        commentResponse.setComment_Response_ID(1);
        commentResponse.setPostComment(postComment1);
        when(commentResponseRepositoryInterface.save((CommentResponse) any())).thenReturn(commentResponse);

        DocumentPost documentPost2 = new DocumentPost();
        documentPost2.setDocument_Id(123);
        documentPost2.setPostComments(new ArrayList<>());
        documentPost2.setPostMessage("Post Message");
        documentPost2.setPost_Id(123);
        documentPost2.setUserId(123);

        PostComment postComment2 = new PostComment();
        postComment2.setCommentMessage("Comment Message");
        postComment2.setCommentResponseLis(new ArrayList<>());
        postComment2.setComment_Id(123);
        postComment2.setDocumentPost(documentPost2);
        postComment2.setUserId(123);

        CommentResponse commentResponse1 = new CommentResponse();
        commentResponse1.setCommentResponse("Comment Response");
        commentResponse1.setComment_Response_ID(1);
        commentResponse1.setPostComment(postComment2);
        BaseResponse<CommentResponse> actualSaveCommenResponseServiceResult = commentResponseServiceImpl
                .saveCommenResponseService(commentResponse1);
        assertEquals("fail", actualSaveCommenResponseServiceResult.getReasonCode());
        assertEquals("500", actualSaveCommenResponseServiceResult.getStatus());
        assertNull(actualSaveCommenResponseServiceResult.getResponseObject());
        assertEquals("fail", actualSaveCommenResponseServiceResult.getReasonText());
        verify(commentRepositoryInterface).findById((Integer) any());
        verify(commentResponseRepositoryInterface).save((CommentResponse) any());
        verify(commentResponse).getComment_Response_ID();
        verify(commentResponse).setCommentResponse((String) any());
        verify(commentResponse).setComment_Response_ID((Integer) any());
        verify(commentResponse).setPostComment((PostComment) any());
    }


    @Test
    void testDeleteComment() {
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
        Optional<CommentResponse> ofResult = Optional.of(commentResponse);
        doNothing().when(commentResponseRepositoryInterface).delete((CommentResponse) any());
        when(commentResponseRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        BaseResponse<CommentResponse> actualDeleteCommentResult = commentResponseServiceImpl.deleteComment(1);
        assertEquals("success", actualDeleteCommentResult.getReasonCode());
        assertEquals("success", actualDeleteCommentResult.getStatus());
        assertNull(actualDeleteCommentResult.getResponseObject());
        assertEquals("Comment Response is deleted", actualDeleteCommentResult.getReasonText());
        verify(commentResponseRepositoryInterface).findById((Integer) any());
        verify(commentResponseRepositoryInterface).delete((CommentResponse) any());
    }


    @Test
    void testDeleteComment2() {
        doNothing().when(commentResponseRepositoryInterface).delete((CommentResponse) any());
        when(commentResponseRepositoryInterface.findById((Integer) any())).thenReturn(null);
        BaseResponse<CommentResponse> actualDeleteCommentResult = commentResponseServiceImpl.deleteComment(1);
        assertEquals("fail", actualDeleteCommentResult.getReasonCode());
        assertEquals("fail", actualDeleteCommentResult.getStatus());
        assertNull(actualDeleteCommentResult.getResponseObject());
        assertNull(actualDeleteCommentResult.getReasonText());
        verify(commentResponseRepositoryInterface).findById((Integer) any());
    }
}

