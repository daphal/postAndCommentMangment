package com.abcBank.postAndCommentMangment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "commentResponse")

@JsonIgnoreProperties
public class CommentResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_Response_ID")
    private Integer comment_Response_ID;
    @NotNull
    @Column(name = "commentResponse")
    private String commentResponse;

    @JsonBackReference
    @ManyToOne()
    private PostComment postComment;
}
