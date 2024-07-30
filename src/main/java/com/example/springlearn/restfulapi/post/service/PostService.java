package com.example.springlearn.restfulapi.post.service;

import java.util.List;
import java.util.Objects;
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

	@Transactional
	public PostDTO updatePost(Long postId, PostDTO postDTO) {
		Post post = postRepository.findById(postId).orElse(null);

		if (post != null) {
			post.updatePost(postDTO);

			postRepository.save(post);
		}

		return PostDTO.toDTO(Objects.requireNonNull(post)); // Objects.requireNonNull(): Null 처리 메서드
	}

	@Transactional
	public boolean deletePost(Long postId) {
		return postRepository.findById(postId)
			.map(post -> {
				postRepository.delete(post);
				return true;
			})
			.orElse(false);
	}
}