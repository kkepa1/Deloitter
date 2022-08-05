package com.deloitte.deloitter.comment.controller;

import com.deloitte.deloitter.comment.service.ICommentService;
import com.deloitte.deloitter.mapstruct.dtos.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDto> getDwitt(@PathVariable Long id) {
        return new ResponseEntity<>(
                commentService.findCommentById(id),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CommentDto>> getDwittsByUser(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(
                commentService.findAllByUserId(userId),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "")
    public ResponseEntity<Comment> postDwitt(@Valid @RequestBody Comment comment) {
        return new ResponseEntity<>(
                commentService.saveComment(comment),
                HttpStatus.OK
        );
    }
}