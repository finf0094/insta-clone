package com.insta.clone.service.impl;

import com.insta.clone.dto.post.PostCreateDTO;
import com.insta.clone.exception.NotFoundException;
import com.insta.clone.model.Post;
import com.insta.clone.repository.PostRepository;
import com.insta.clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("post with id %s not found", id))
        );
    }


    @Override
    public void like(Long id) {
        Post post = findById(id);
        post.setLikesCount(post.getLikesCount() + 1);
        postRepository.save(post);
    }

    @Override
    public void dislike(Long id) {
        Post post = findById(id);
        post.setDislikeCount(post.getDislikeCount() + 1);
        postRepository.save(post);
    }

    @Override
    public Post createPost(PostCreateDTO postCreateDTO) {
        Post post = Post.builder()
                .authorName(postCreateDTO.getAuthorName())
                .name(postCreateDTO.getName())
                .description(postCreateDTO.getDescription())
                .imageUrl(postCreateDTO.getImageUrl())
                .likesCount(0L)
                .dislikeCount(0L)
                .build();


        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}