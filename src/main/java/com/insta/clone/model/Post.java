package com.insta.clone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "image_url", length = 2048)
    private String imageUrl;

    @Column(name = "likes_count")
    private Long likesCount;

    @Column(name = "dislike_count")
    private Long dislikeCount;

    @OneToMany
    @JoinColumn(name = "post_id")
    @JsonManagedReference
    private List<Comment> comments;
}