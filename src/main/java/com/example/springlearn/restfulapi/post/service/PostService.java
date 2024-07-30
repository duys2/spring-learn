package com.example.springlearn.restfulapi.post.service;

import java.util.List;
import java.util.Optional;

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

	@Transactional
	public List<PostDTO> getAllPosts() {
		List<Post> posts = postRepository.findAll();

		return posts.stream()
			.map(PostDTO::toDTO)
			// .map(e -> PostDTO.toDTO(e))
			.toList();
	}

	@Transactional
	public Optional<PostDTO> getPostById(Long id) { // 단일 객체 반환은 Optional 사용
		Optional<Post> posts = postRepository.findById(id);

		return posts.map(PostDTO::toDTO);
	}
}