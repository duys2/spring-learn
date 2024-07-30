package com.example.springlearn.restfulapi.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
		PostDTO createPostDTO = postService.createPost(postDTO);

		return ResponseEntity.ok(createPostDTO);
	}
}