package com.example.springlearn.post_crud;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private Long id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
}