package com.abcBank.postAndCommentMangment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DocumentLog implements Serializable {
    private Integer documentLog_Id;
    private LocalDateTime documentModifedTime = LocalDateTime.now();
}