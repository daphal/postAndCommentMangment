package com.abcBank.postAndCommentMangment.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import java.util.List;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserDetails {


    private Integer user_Id;

    private String userName;

    @JsonIgnore
    private List<Document> documents;
}
