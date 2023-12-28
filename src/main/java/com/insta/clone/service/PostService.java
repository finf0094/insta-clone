package com.insta.clone.service;


import com.insta.clone.dto.post.PostCreateDTO;
import com.insta.clone.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();

    public Post findById(Long id);

    public void like(Long id);

    public void dislike(Long id);

    public Post createPost(PostCreateDTO postCreateDTO);

    public void deletePost(Long id);
}
