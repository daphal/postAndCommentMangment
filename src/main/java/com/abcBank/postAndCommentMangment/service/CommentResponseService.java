package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;

public interface CommentResponseService {
    BaseResponse<CommentResponse> saveCommenResponseService(CommentResponse commentResponse);
}
