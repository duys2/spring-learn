package com.example.springlearn.coupling.tight;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryInterface {
	/* ---------------- 강결합 코드 ---------------- */
	// public void save(User user) {
	// 	System.out.println("User saved");
	// }

	/* ---------------- 약결합 코드 ---------------- */
	@Override
	public void save(User user) {
		System.out.println("User saved");
	}
}