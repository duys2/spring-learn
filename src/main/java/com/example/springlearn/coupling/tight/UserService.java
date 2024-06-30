package com.example.springlearn.coupling.tight;

import org.springframework.stereotype.Service;

@Service //어노테이션을 붙이면 UserService는 Bean이 된다.
public class UserService {
	/* ---------------- 강결합 코드 ---------------- */
	// private UserRepository userRepository;
	//
	// public UserService() {
	// 	this.userRepository = new UserRepository();
	// }


	/* ---------------- 약결합 코드 ---------------- */
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(User user) {
		userRepository.save(user);
		System.out.println("User created");
	}
}