package com.leandro.blogging_api.service.impl;

import com.leandro.blogging_api.dto.PostDto;
import com.leandro.blogging_api.entity.Post;
import com.leandro.blogging_api.exception.ResourceNotFoundException;
import com.leandro.blogging_api.mapper.PostMapper;
import com.leandro.blogging_api.repository.PostRepository;
import com.leandro.blogging_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = PostMapper.mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        return PostMapper.mapToDto(savedPost);
    }

    @Override
    public PostDto getPostById(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return PostMapper.mapToDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return PostMapper.mapToDto(updatedPost);
    }

    @Override
    public void deletePost(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));

        postRepository.delete(post);
    }
}
