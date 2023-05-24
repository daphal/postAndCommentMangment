package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.PostComment;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    BaseResponse<PostComment> saveCommentService(PostComment postComment);

    BaseResponse<PostComment> deleteComment(Integer id);
}
