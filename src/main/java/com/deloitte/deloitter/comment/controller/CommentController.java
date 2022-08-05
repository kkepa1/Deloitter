package com.deloitte.deloitter.comment.controller;

import com.deloitte.deloitter.comment.service.ICommentService;
import com.deloitte.deloitter.comment.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping(value = "/{id}")
    public Comment getComment(@PathVariable Long id) {

        return commentService.findCommentById(id);
    }

    @GetMapping(value = "")
    public List<Comment> getCommentByUser(@RequestParam("userId") Long userId) {
        return commentService.findAllByUserId(userId);
    }

    @PostMapping(value = "")
    public Comment postComment(@Valid @RequestBody Comment comment) {

        return commentService.saveComment(comment);
    }
}