package com.example.springlearn.restfulapi.post.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.restfulapi.post.dto.PostDTO;
import com.example.springlearn.restfulapi.post.service.PostService;

@RestController
@RequestMapping("/spring-learn/posts")
public class PostController {
	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 게시글 작성
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
		PostDTO createPostDTO = postService.createPost(postDTO);

		return ResponseEntity.ok(createPostDTO);
	}

	// 모든 게시글 조회
	@GetMapping("/list")
	public ResponseEntity<List<PostDTO>> getAllPosts() {
		List<PostDTO> postDTOList = postService.getAllPosts();

		return ResponseEntity.ok(postDTOList);
	}

	// 게시글 ID로 특정 게시글 조회
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PostDTO>> getPostById(@PathVariable Long id) {
		Optional<PostDTO> postDTO = postService.getPostById(id);

		return ResponseEntity.ok(postDTO);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO) {
		PostDTO result = postService.updatePost(postId, postDTO);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<Optional<PostDTO>> deletePostById(@PathVariable Long postId) {
		boolean deleted = postService.deletePost(postId);

		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}