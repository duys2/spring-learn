/*
package com.example.springlearn.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	*/
/* ---------------- Setter 주입 방식 ---------------- *//*

	*/
/*private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;*//*


	*/
/* ---------------- field 주입 방식 ---------------- *//*

	*/
/*@Autowired
	private UserRepository userRepository;*//*


	*/
/* ---------------- 생성자(Constructor) 주입 방식 ---------------- *//*

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}*/
