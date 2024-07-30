package com.example.springlearn.restfulapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springlearn.restfulapi.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}