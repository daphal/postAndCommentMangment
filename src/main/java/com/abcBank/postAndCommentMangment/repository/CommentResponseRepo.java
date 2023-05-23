package com.abcBank.postAndCommentMangment.repository;

import com.abcBank.postAndCommentMangment.model.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentResponseRepo extends JpaRepository<CommentResponse,Integer> {
}
