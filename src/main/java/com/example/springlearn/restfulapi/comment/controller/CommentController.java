package com.example.springlearn.restfulapi.comment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.springlearn.restfulapi.comment.dto.CommentDTO;
import com.example.springlearn.restfulapi.comment.service.CommentService;
import com.example.springlearn.restfulapi.post.dto.PostDTO;

@RestController
@RequestMapping("/spring-learn/comments")
public class CommentController {
	private final CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto) {
		CommentDTO createComment = commentService.createComment(commentDto);

		return new ResponseEntity<>(createComment, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<List<CommentDTO>> getAllComments() {
		List<CommentDTO> commentDtoList = commentService.getAllComments();

		return ResponseEntity.ok(commentDtoList);
	}

	@GetMapping
	public ResponseEntity<List<CommentDTO>> getCommentByPostId(@RequestBody PostDTO postDTO) {
		List<CommentDTO> commentDtoList = commentService.getCommentsByPostId(postDTO);
		System.out.println(commentDtoList);
		return ResponseEntity.ok(commentDtoList);
	}

	@PutMapping
	public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDto) {
		return ResponseEntity.ok(commentService.updateComment(commentDto));
	}

	@DeleteMapping
	public ResponseEntity<?> deleteComment(@RequestBody Map<String, Long> request) {
		try {
			Long commentId = request.get("commentId");

			commentService.deleteComment(commentId);

			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}