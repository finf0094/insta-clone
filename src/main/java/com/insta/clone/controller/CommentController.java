package com.insta.clone.controller;

import com.insta.clone.dto.comment.CommentCreateDTO;
import com.insta.clone.model.Comment;
import com.insta.clone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.findAllByPostId(postId);
    }

    @PostMapping
    public Comment createComment(@PathVariable Long postId, @RequestBody CommentCreateDTO comment) {
        return commentService.createComment(postId, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}