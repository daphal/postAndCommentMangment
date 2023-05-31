package com.abcBank.postAndCommentMangment.repository;

import com.abcBank.postAndCommentMangment.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.RequestEntity;

public interface CommentRepositoryInterface extends JpaRepository<PostComment,Integer> {
    @Query(" from PostComment as a inner join a.documentPost as b where b.id=?1")
    PostComment  findCommentByPostId(Integer post_id);
}
