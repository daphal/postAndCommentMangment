package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostInfo;
import com.abcBank.postAndCommentMangment.model.PostInfoSave;
import org.springframework.stereotype.Service;


public interface DocumentPostService {
    BaseResponse<DocumentPost> savePost(DocumentPost documentPost);
    BaseResponse<PostInfo> getPostInfoByPostId(int id);
    BaseResponse<DocumentPost> deletePost(Integer id);

    BaseResponse<PostInfoSave> savePost1(PostInfoSave postInfo);
}