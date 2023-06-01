package com.abcBank.postAndCommentMangment.service;

import com.abcBank.postAndCommentMangment.model.BaseResponse;
import com.abcBank.postAndCommentMangment.model.CommentResponse;
import com.abcBank.postAndCommentMangment.model.CommonResponseData;
import com.abcBank.postAndCommentMangment.model.PostComment;
import com.abcBank.postAndCommentMangment.repository.CommentRepositoryInterface;
import com.abcBank.postAndCommentMangment.repository.CommentResponseRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentResponseServiceImpl implements CommentResponseService {
    @Autowired
    CommentResponseRepositoryInterface commentResponseRepositoryInterface;
    @Autowired
    CommentRepositoryInterface commentRepositoryInterface;

    @Override
    public BaseResponse<CommentResponse> saveCommenResponseService(CommentResponse commentResponse) {
        BaseResponse<CommentResponse> baseResponse = new BaseResponse<>();
        PostComment postComment = commentRepositoryInterface.findById(commentResponse.getPostComment().getComment_Id()).get();
        if (postComment != null) {
            CommentResponse commentResponseNew = commentResponseRepositoryInterface.save(commentResponse);
            if (commentResponseNew.getComment_Response_ID() > 0) {
                baseResponse.setResponseObject(commentResponseNew);
                baseResponse.setStatus(CommonResponseData.SUCCESS);
                baseResponse.setReasonCode("200");
                baseResponse.setReasonText(CommonResponseData.SUCCESS);
            } else {
                baseResponse.setResponseObject(null);
                baseResponse.setReasonCode(CommonResponseData.FAIL);
                baseResponse.setStatus("500");
                baseResponse.setReasonText(CommonResponseData.FAIL);
            }
        } else {
            baseResponse.setReasonText("comment is not found ");
            baseResponse.setReasonCode(CommonResponseData.FAIL);
            baseResponse.setStatus(CommonResponseData.FAIL);
            baseResponse.setResponseObject(null);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CommentResponse> deleteComment(Integer id) {
        BaseResponse<CommentResponse> response = new BaseResponse<>();
            CommentResponse commentResponse = commentResponseRepositoryInterface.findById(id).get();
            if (commentResponse != null) {
                commentResponseRepositoryInterface.delete(commentResponse);
                response.setResponseObject(null);
                response.setReasonCode(CommonResponseData.SUCCESS);
                response.setStatus(CommonResponseData.SUCCESS);
                response.setReasonText("Comment Response is deleted");
            } else {
                response.setReasonText("comment Response is not found ");
                response.setReasonCode(CommonResponseData.FAIL);
                response.setStatus(CommonResponseData.FAIL);
                response.setResponseObject(null);
            }
        return response;
    }
}