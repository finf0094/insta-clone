package com.insta.clone.service;

import com.insta.clone.dto.comment.CommentCreateDTO;
import com.insta.clone.model.Comment;
import com.insta.clone.model.Post;
import com.insta.clone.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Override
    public List<Comment> findAllByPostId(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Comment createComment(Long postId, CommentCreateDTO commentCreateDTO) {
        Post post = postService.findById(postId);
        Comment comment = Comment.builder()
                .authorName(commentCreateDTO.getAuthorName())
                .body(commentCreateDTO.getBody())
                .post(post)
                .build();

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}