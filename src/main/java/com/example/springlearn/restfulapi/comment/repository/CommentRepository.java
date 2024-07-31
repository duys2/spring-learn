package com.example.springlearn.restfulapi.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springlearn.restfulapi.comment.entity.Comment;
import com.example.springlearn.restfulapi.post.entity.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPost(Post post);
}