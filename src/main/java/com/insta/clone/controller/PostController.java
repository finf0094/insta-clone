package com.insta.clone.controller;

import com.insta.clone.dto.post.PostCreateDTO;
import com.insta.clone.model.Post;
import com.insta.clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateDTO postCreateDTO) {
        return postService.createPost(postCreateDTO);
    }

    @PutMapping("/{id}/like")
    public void likePost(@PathVariable Long id) {
        postService.like(id);
    }

    @PutMapping("/{id}/dislike")
    public void dislikePost(@PathVariable Long id) {
        postService.dislike(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}