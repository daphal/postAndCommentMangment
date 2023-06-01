package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommonResponseData;
import com.abcBank.postAndCommentMangment.model.DocumentPost;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.repository.CommentRepositoryInterface;
import com.abcBank.postAndCommentMangment.repository.DocumentPostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepositoryInterface commentRepositoryInterface;
    @Autowired
    DocumentPostRepositoryInterface documentPostRepositoryInterface;

    @Override
    public BaseResponse<PostComment> saveCommentService(PostComment postComment) {
        PostComment postCommentNew;
        BaseResponse baseResponse = new BaseResponse();
        DocumentPost documentPost = documentPostRepositoryInterface.findById(postComment.getDocumentPost().getPost_Id()).get();
        if (documentPost != null) {
            postCommentNew = commentRepositoryInterface.save(postComment);
            if (postCommentNew.getComment_Id() > 0) {
                baseResponse.setStatus("200");
                baseResponse.setResponseObject(postCommentNew);
                baseResponse.setReasonCode(CommonResponseData.SUCCESS);
                baseResponse.setReasonText(CommonResponseData.SUCCESS);
            } else {
                baseResponse.setResponseObject(null);
                baseResponse.setReasonCode(CommonResponseData.FAIL);
                baseResponse.setStatus("500");
                baseResponse.setReasonText(CommonResponseData.FAIL);
            }
        } else {
            baseResponse.setResponseObject(null);
            baseResponse.setReasonCode(CommonResponseData.FAIL);
            baseResponse.setStatus("404");
            baseResponse.setReasonText("Post is not found");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<PostComment> deleteComment(Integer id) {
        BaseResponse<PostComment> response = new BaseResponse<>();
            PostComment postComment = commentRepositoryInterface.findById(id).get();
            if (postComment != null) {
                commentRepositoryInterface.delete(postComment);
                response.setResponseObject(null);
                response.setReasonCode(CommonResponseData.SUCCESS);
                response.setStatus(CommonResponseData.SUCCESS);
                response.setReasonText("Comment is deleted");
            } else {
                response.setReasonText("comment is not found ");
                response.setReasonCode(CommonResponseData.FAIL);
                response.setStatus(CommonResponseData.FAIL);
                response.setResponseObject(null);
            }
        return response;
    }
}