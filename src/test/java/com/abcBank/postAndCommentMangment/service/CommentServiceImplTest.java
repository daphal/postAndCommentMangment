package com.abcBank.postAndCommentMangment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.repository.CommentRepositoryInterface;
import com.abcBank.postAndCommentMangment.repository.DocumentPostRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CommentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CommentServiceImplTest {
    @MockBean
    private CommentRepositoryInterface commentRepositoryInterface;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @MockBean
    private DocumentPostRepositoryInterface documentPostRepositoryInterface;


    @Test
    void testSaveCommentService() {
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
        when(commentRepositoryInterface.save((PostComment) any())).thenReturn(postComment);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost1);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

        DocumentPost documentPost2 = new DocumentPost();
        documentPost2.setDocument_Id(123);
        documentPost2.setPostComments(new ArrayList<>());
        documentPost2.setPostMessage("Post Message");
        documentPost2.setPost_Id(123);
        documentPost2.setUserId(123);

        PostComment postComment1 = new PostComment();
        postComment1.setCommentMessage("Comment Message");
        postComment1.setCommentResponseLis(new ArrayList<>());
        postComment1.setComment_Id(123);
        postComment1.setDocumentPost(documentPost2);
        postComment1.setUserId(123);
        BaseResponse<PostComment> actualSaveCommentServiceResult = commentServiceImpl.saveCommentService(postComment1);
        assertEquals("success", actualSaveCommentServiceResult.getReasonCode());
        assertEquals("200", actualSaveCommentServiceResult.getStatus());
        assertSame(postComment, actualSaveCommentServiceResult.getResponseObject());
        assertEquals("success", actualSaveCommentServiceResult.getReasonText());
        verify(commentRepositoryInterface).save((PostComment) any());
        verify(documentPostRepositoryInterface).findById((Integer) any());
    }


    @Test
    void testSaveCommentService2() {
        DocumentPost documentPost = new DocumentPost();
        documentPost.setDocument_Id(123);
        documentPost.setPostComments(new ArrayList<>());
        documentPost.setPostMessage("Post Message");
        documentPost.setPost_Id(123);
        documentPost.setUserId(123);
        PostComment postComment = mock(PostComment.class);
        when(postComment.getComment_Id()).thenReturn(-1);
        doNothing().when(postComment).setCommentMessage((String) any());
        doNothing().when(postComment).setCommentResponseLis((List<CommentResponse>) any());
        doNothing().when(postComment).setComment_Id((Integer) any());
        doNothing().when(postComment).setDocumentPost((DocumentPost) any());
        doNothing().when(postComment).setUserId(anyInt());
        postComment.setCommentMessage("Comment Message");
        postComment.setCommentResponseLis(new ArrayList<>());
        postComment.setComment_Id(123);
        postComment.setDocumentPost(documentPost);
        postComment.setUserId(123);
        when(commentRepositoryInterface.save((PostComment) any())).thenReturn(postComment);

        DocumentPost documentPost1 = new DocumentPost();
        documentPost1.setDocument_Id(123);
        documentPost1.setPostComments(new ArrayList<>());
        documentPost1.setPostMessage("Post Message");
        documentPost1.setPost_Id(123);
        documentPost1.setUserId(123);
        Optional<DocumentPost> ofResult = Optional.of(documentPost1);
        when(documentPostRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);

        DocumentPost documentPost2 = new DocumentPost();
        documentPost2.setDocument_Id(123);
        documentPost2.setPostComments(new ArrayList<>());
        documentPost2.setPostMessage("Post Message");
        documentPost2.setPost_Id(123);
        documentPost2.setUserId(123);

        PostComment postComment1 = new PostComment();
        postComment1.setCommentMessage("Comment Message");
        postComment1.setCommentResponseLis(new ArrayList<>());
        postComment1.setComment_Id(123);
        postComment1.setDocumentPost(documentPost2);
        postComment1.setUserId(123);
        BaseResponse<PostComment> actualSaveCommentServiceResult = commentServiceImpl.saveCommentService(postComment1);
        assertEquals("fail", actualSaveCommentServiceResult.getReasonCode());
        assertEquals("500", actualSaveCommentServiceResult.getStatus());
        assertNull(actualSaveCommentServiceResult.getResponseObject());
        assertEquals("fail", actualSaveCommentServiceResult.getReasonText());
        verify(commentRepositoryInterface).save((PostComment) any());
        verify(postComment).getComment_Id();
        verify(postComment).setCommentMessage((String) any());
        verify(postComment).setCommentResponseLis((List<CommentResponse>) any());
        verify(postComment).setComment_Id((Integer) any());
        verify(postComment).setDocumentPost((DocumentPost) any());
        verify(postComment).setUserId(anyInt());
        verify(documentPostRepositoryInterface).findById((Integer) any());
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
        Optional<PostComment> ofResult = Optional.of(postComment);
        doNothing().when(commentRepositoryInterface).delete((PostComment) any());
        when(commentRepositoryInterface.findById((Integer) any())).thenReturn(ofResult);
        BaseResponse<PostComment> actualDeleteCommentResult = commentServiceImpl.deleteComment(1);
        assertEquals("success", actualDeleteCommentResult.getReasonCode());
        assertEquals("success", actualDeleteCommentResult.getStatus());
        assertNull(actualDeleteCommentResult.getResponseObject());
        assertEquals("Comment is deleted", actualDeleteCommentResult.getReasonText());
        verify(commentRepositoryInterface).findById((Integer) any());
        verify(commentRepositoryInterface).delete((PostComment) any());
    }


    @Test
    void testDeleteComment2() {
        doNothing().when(commentRepositoryInterface).delete((PostComment) any());
        when(commentRepositoryInterface.findById((Integer) any())).thenReturn(null);
        BaseResponse<PostComment> actualDeleteCommentResult = commentServiceImpl.deleteComment(1);
        assertEquals("fail", actualDeleteCommentResult.getReasonCode());
        assertEquals("fail", actualDeleteCommentResult.getStatus());
        assertNull(actualDeleteCommentResult.getResponseObject());
        assertNull(actualDeleteCommentResult.getReasonText());
        verify(commentRepositoryInterface).findById((Integer) any());
    }
}

