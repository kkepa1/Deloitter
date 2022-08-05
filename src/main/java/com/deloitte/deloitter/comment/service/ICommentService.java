package com.deloitte.deloitter.comment.service;

import com.deloitte.deloitter.comment.entity.Comment;

import java.util.List;

public interface ICommentService {

    Comment findCommentById(Long id);

    List<Comment> findAllByUserId(Long user_id);

    Comment saveComment(Comment comment);

    Comment updateComment(Comment comment);

    String deleteCommentById(Long id);
}
