package com.example.springlearn.restfulapi.comment.dto;

import java.time.LocalDateTime;

import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.post.entity.Post;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentDTO {
	private Long id;
	private Long postId;
	private String content;
	private String author;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;

	public static CommentDTO toDTO(Comment comment) {
		return CommentDTO.builder()
			.id(comment.getId())
			.postId(comment.getId())
			.content(comment.getContent())
			.author(comment.getAuthor())
			.createAt(comment.getCreateAt())
			.updateAt(comment.getUpdateAt())
			.build();
	}

	public static Comment toComment(CommentDTO commentDTO, Post post) {
		return Comment.builder()
			.id(commentDTO.id)
			.post(post)
			.content(commentDTO.content)
			.author(commentDTO.author)
			.createAt(commentDTO.createAt)
			.updateAt(commentDTO.updateAt)
			.build();
	}
}