package com.insta.clone.dto.post;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
public class PostCreateDTO {
    private String authorName;
    private String name;
    private String description;
    private String imageUrl;
}
