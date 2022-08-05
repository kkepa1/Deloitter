package com.deloitte.deloitter.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitter.comment.entity.Comment;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentById(Long id);

    List<Comment> findAllByUserId(Long user_id);
}