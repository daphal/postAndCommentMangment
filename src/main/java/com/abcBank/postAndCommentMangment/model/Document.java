package com.abcBank.postAndCommentMangment.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Document {

    private Integer document_Id;
    private String documentName;
    private String documentData;
    private String documentType;
    @JsonIgnore

    private UserDetails userDetails;
    private Boolean deleted = false;
    @JsonIgnore

    private List<DocumentLog> documentLogs;
}
