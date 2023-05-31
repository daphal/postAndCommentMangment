package com.abcBank.postAndCommentMangment.repository;

import com.abcBank.postAndCommentMangment.model.DocumentPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentPostRepositoryInterface extends JpaRepository<DocumentPost, Integer> {
}
