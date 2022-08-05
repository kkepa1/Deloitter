package com.deloitte.deloitter.comment.service;

import com.deloitte.deloitter.comment.repository.CommentRepository;
import com.deloitte.deloitter.mapstruct.dtos.CommentDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.stream.events.Comment;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CommentServiceImpl implements ICommentService {

    private CommentRepository commentRepository;

    private MapStructMapper mapStructMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, MapStructMapper mapStructMapper) {
        this.commentRepository = commentRepository;
        this.mapStructMapper = mapStructMapper;
    }


    @Override
    public CommentDto findCommentById(Long id) {
        return mapStructMapper.commentToCommentDto(commentRepository.findCommentById(id));
    }

    @Override
    public List<CommentDto> findAllByUserId(Long user_id) {
        if (commentRepository.findAllByUserId(user_id) != null) {
            return mapStructMapper.commentToCommentDtoList(commentRepository.findAllByUserId(user_id));
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find comments with given user_id");
    }

    @Override
    public Comment saveComment(Comment comment) {
        if (commentRepository.findCommentById(comment.getId()) == null) {
            return commentRepository.save(comment);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "unable to find comment with given id");
        }
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment upComment = commentRepository.findCommentById(comment.getId());
        if (upComment != null) {
            upComment.setContent(comment.getContent());
            return mapStructMapper.commentToCommentDto(commentRepository.save(upComment));
        }
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find comment with given id");
    }

    @Override
    public String deleteCommentById(Long id) {
        if (commentRepository.findCommentById(id) != null) {
            commentRepository.delete(commentRepository.findCommentById(id));
            return "comment deleted";
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find comment with given id");
    }


}
