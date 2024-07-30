package com.example.springlearn.restfulapi.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springlearn.restfulapi.post.dto.PostDTO;
import com.example.springlearn.restfulapi.post.entity.Post;
import com.example.springlearn.restfulapi.post.repository.PostRepository;

@Service
public class PostService {
	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Transactional
	public PostDTO createPost(PostDTO postDTO) {
		Post createPost = PostDTO.toEntity(postDTO);

		postRepository.save(createPost);

		return PostDTO.toDTO(createPost);
	}
}