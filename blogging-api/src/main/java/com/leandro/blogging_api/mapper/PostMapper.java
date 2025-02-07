package com.leandro.blogging_api.mapper;

import com.leandro.blogging_api.dto.PostDto;
import com.leandro.blogging_api.entity.Post;

public class PostMapper {

    // Converte Entity -> DTO
    public static PostDto mapToDto(Post post) {
        return new PostDto(
          post.getId(),
          post.getTitle(),
          post.getContent()
        );
    }

    // Converte DTO -> Entity
    public static Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
