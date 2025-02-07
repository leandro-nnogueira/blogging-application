package com.leandro.blogging_api.service;

import com.leandro.blogging_api.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long id);

    List<PostDto> getAllPosts();

    PostDto updatePost(Long id, PostDto postDto);

    void deletePost(Long id);
}
