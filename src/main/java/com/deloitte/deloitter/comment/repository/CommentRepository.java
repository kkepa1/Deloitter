package com.deloitte.deloitter.comment.repository;

import com.deloitte.deloitter.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentById(Long id);

    List<Comment> findAllByUserId(Long user_id);
}