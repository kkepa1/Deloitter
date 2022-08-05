package com.deloitte.deloitter.comment.service;

import com.deloitte.deloitter.comment.entity.Comment;
import com.deloitte.deloitter.mapstruct.dtos.CommentDto;

import java.util.List;

public interface ICommentService {

    CommentDto findCommentById(Long id);

    List<CommentDto> findAllByUserId(Long user_id);

    Comment saveComment(Comment comment);

    CommentDto updateComment(Comment comment);

    String deleteCommentById(Long id);
}
