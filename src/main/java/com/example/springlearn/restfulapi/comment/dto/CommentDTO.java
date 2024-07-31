package com.example.springlearn.restfulapi.comment.dto;

import java.time.LocalDateTime;

import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.post.entity.Post;

import lombok.*;

@Builder
@Getter
public class CommentDTO {
	private Long commentId;
	private Long postId;
	private String content;
	private String author;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;

	public static CommentDTO toDTO(Comment comment) {
		return CommentDTO.builder()
			.commentId(comment.getCommentId())
			.postId(comment.getPost().getPostId())
			.content(comment.getContent())
			.author(comment.getAuthor())
			.createAt(comment.getCreateAt())
			.updateAt(comment.getUpdateAt())
			.build();
	}

	public static Comment toEntity(CommentDTO commentDTO, Post post) {
		return Comment.builder()
			.commentId(commentDTO.commentId)
			.post(post)
			.content(commentDTO.content)
			.author(commentDTO.author)
			.createAt(commentDTO.getCommentId() == null ? LocalDateTime.now() : commentDTO.getCreateAt())
			.updateAt(commentDTO.getCommentId() == null ? null : LocalDateTime.now())
			.build();
	}
}