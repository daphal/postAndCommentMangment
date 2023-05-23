package com.abcBank.postAndCommentMangment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DocumentPost")

@JsonIgnoreProperties
public class DocumentPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "document_Id")
    private Integer document_Id;

    @NotNull
    @Column(name = "postMessage")
    private String postMessage;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentPost", fetch = FetchType.EAGER)
    private List<PostComment> postComments;

    @Column(name="userId")
    private int userId;



}
