package com.example.springlearn.restfulapi.comment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springlearn.restfulapi.comment.dto.CommentDTO;
import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.comment.repository.CommentRepository;

import com.example.springlearn.restfulapi.post.dto.PostDTO;
import com.example.springlearn.restfulapi.post.entity.Post;
import com.example.springlearn.restfulapi.post.repository.PostRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	@Transactional
	public CommentDTO createComment(CommentDTO commentDTO) {
		Post post = postRepository.findById(commentDTO.getPostId())
			.orElseThrow(() -> new IllegalArgumentException("잘못된 게시글 ID 입니다."));

		Comment comment = CommentDTO.toEntity(commentDTO, post);

		Comment savedComment = commentRepository.save(comment);

		return CommentDTO.toDTO(savedComment);
	}

	@Transactional
	public List<CommentDTO> getAllComments() {
		List<Comment> comments = commentRepository.findAll();

		return comments.stream()
			.map(CommentDTO::toDTO)
			.collect(Collectors.toList());
	}

	@Transactional
	public List<CommentDTO> getCommentsByPostId(PostDTO postDto) {
		Post post = postRepository.findById(postDto.getPostId())
			.orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없습니다."));

		List<Comment> comments = commentRepository.findByPost(post);

		return comments.stream()
			.map(CommentDTO::toDTO)
			.collect(Collectors.toList());
	}

	@Transactional
	public CommentDTO updateComment(CommentDTO commentDTO
	) {
		Comment comment = commentRepository.findById(commentDTO.getCommentId())
			.orElseThrow(() -> new IllegalArgumentException("잘못된 댓글 ID 입니다."));

		comment.updateComment(commentDTO);

		return CommentDTO.toDTO(comment);
	}

	@Transactional
	public void deleteComment(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다"));

		commentRepository.delete(comment);
	}
}