package com.example.springlearn.restfulapi.comment.entity;

import java.time.LocalDateTime;

import com.example.springlearn.restfulapi.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "create_at", nullable = false, updatable = false) // updatable = false: (읽기 전용 필드)
	private LocalDateTime createAt;

	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@ManyToOne
	@JoinColumn(name = "post_id")
	@JsonIgnore
	private Post post;
}