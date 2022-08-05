package com.deloitte.deloitter.comment.service;

import com.deloitte.deloitter.comment.entity.Comment;
import com.deloitte.deloitter.mapstruct.dtos.CommentDto;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface ICommentService {

    CommentDto findCommentById(Long id);

    List<CommentDto> findAllByUserId(Long user_id);

    Comment saveComment(Comment comment);

    Comment updateComment(Comment comment);

}
