package com.abcBank.postAndCommentMangment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserDetails implements Serializable {
    private Integer user_Id;
    private String userName;
    private List<Document> documents;
}
