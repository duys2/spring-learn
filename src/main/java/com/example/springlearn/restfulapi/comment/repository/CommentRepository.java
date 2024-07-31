package com.example.springlearn.restfulapi.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.post.entity.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	// 특정 게시글(Post)에 달린 모든 댓글(Comment)을 찾아 리스트 형태로 반환하는 쿼리 메서드
	List<Comment> findByPost(Post post);
}