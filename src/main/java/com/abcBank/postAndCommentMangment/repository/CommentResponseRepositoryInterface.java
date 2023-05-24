package com.abcBank.postAndCommentMangment.repository;

import com.abcBank.postAndCommentMangment.model.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentResponseRepositoryInterface extends JpaRepository<CommentResponse, Integer> {
}
