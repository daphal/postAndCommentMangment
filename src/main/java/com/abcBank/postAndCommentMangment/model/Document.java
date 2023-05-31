package com.abcBank.postAndCommentMangment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Document implements Serializable {
    private Integer document_Id;
    private String documentName;
    private String documentData;
    private String documentType;
    private Boolean deleted = false;
    @JsonIgnore
    private List<DocumentLog> documentLogs;
}