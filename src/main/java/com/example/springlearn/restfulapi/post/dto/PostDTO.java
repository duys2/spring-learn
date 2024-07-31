package com.example.springlearn.restfulapi.post.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.springlearn.restfulapi.comment.dto.CommentDTO;
import com.example.springlearn.restfulapi.post.entity.Post;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDTO {
	private Long postId;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;

	private List<CommentDTO> comments;

	public static PostDTO toDTO(Post post) {
		return PostDTO
			.builder()
			.postId(post.getPostId())
			.title(post.getTitle())
			.content(post.getContent())
			.author(post.getAuthor())
			.createAt(post.getCreateAt())
			.updateAt(post.getUpdateAt())
			.build();
	}

	public static Post toEntity(PostDTO postDTO) {
		return Post
			.builder()
			.postId(postDTO.getPostId())
			.title(postDTO.getTitle())
			.content(postDTO.getContent())
			.author(postDTO.getAuthor())
			// null 처리
			.createAt(postDTO.getPostId() == null ? LocalDateTime.now() : postDTO.getCreateAt())
			.updateAt(postDTO.getPostId() == null ? null : LocalDateTime.now())
			.build();
	}
}