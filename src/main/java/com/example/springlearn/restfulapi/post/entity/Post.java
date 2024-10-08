package com.example.springlearn.restfulapi.post.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.post.dto.PostDTO;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // 자바 클래스를 JPA 엔티티로 지정
@Table(name = "post") // 엔티티 클래스가 매핑될 데이터베이스의 테이블 이름 지정
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", nullable = false)
	private Long postId;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "create_at", nullable = false, updatable = false) // updatable = false: (읽기 전용 필드)
	private LocalDateTime createAt;

	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	public void updatePost(PostDTO postDTO) {
		this.title = postDTO.getTitle();
		this.content = postDTO.getContent();
		this.updateAt = LocalDateTime.now();
	}
}