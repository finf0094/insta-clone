package com.insta.clone.service;

import com.insta.clone.dto.comment.CommentCreateDTO;
import com.insta.clone.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllByPostId(Long postId);
    Comment createComment(Long postId, CommentCreateDTO commentCreateDTO);
    void deleteComment(Long id);
}
