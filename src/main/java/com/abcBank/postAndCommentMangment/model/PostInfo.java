package com.abcBank.postAndCommentMangment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostInfo {

    private DocumentPost documentPost;
    private  CommentResponse commentResponse;
    private PostComment postComment;

}
