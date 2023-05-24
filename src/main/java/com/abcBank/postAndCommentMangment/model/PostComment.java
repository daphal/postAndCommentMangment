package com.abcBank.postAndCommentMangment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "PostComment")

@JsonIgnoreProperties
public class PostComment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_Id")
    private Integer comment_Id;

    @NotNull
    @Column(name = "commentMessage")
    private String commentMessage;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "post_Id", nullable = false)
    private DocumentPost documentPost;

    @JsonManagedReference
   @OneToMany(mappedBy = "postComment" ,fetch = FetchType.EAGER)
    List<CommentResponse> commentResponseLis;

    @Column(name="userId")
    private int userId;

}