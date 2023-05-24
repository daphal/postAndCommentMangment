package com.abcBank.postAndCommentMangment.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PostInfo implements Serializable {

    private DocumentPost documentPost;
    private UserDetails userDetails;


}
