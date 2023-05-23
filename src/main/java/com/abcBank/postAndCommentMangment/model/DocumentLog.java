package com.abcBank.postAndCommentMangment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DocumentLog {


    private Integer documentLog_Id;


    private LocalDateTime documentModifedTime = LocalDateTime.now();
    @JsonIgnore

    private Document documents;

}
