package com.example.springlearn.restfulapiexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RESTful API를 위한 MemberController 클래스
@RestController
@RequestMapping("/api/members")
public class MemberController {
	private List<Member> members = new ArrayList<>();
	private long nextId = 1;

	// GET /api/members
	@GetMapping
	// GET 요청을 처리하여 모든 사용자 목록 반환
	public List<Member> getAllMembers() {
		return members;
	}

	// POST /api/members
	@PostMapping
	// POST 요청을 처리하여 새로운 사용자를 생성 후 반환
	public Member createMember(@RequestBody Member member) {
		member.setId(nextId++);
		members.add(member);

		return member;
	}

	// GET /api/members/{commentId}
	@GetMapping("/{id}")
	// GET 요청을 처리하여 특정 ID에 해당하는 사용자 반환, 경로 변수로 사용자 ID를 받는다.
	public Member getMemberById(@PathVariable("id") Long id) {
		// 스트림을 사용하여 ID와 일치하는 멤버 찾기
		return members.stream()
			.filter(member -> member.getId().equals(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다. Id: " + id));
	}

	// PUT /api/members/{commentId}
	@PutMapping("/{id}")
	// PUT 요청을 처리하여 특정 ID에 해당하는 사용자 정보를 업데이트하고 반환
	// 경로 변수로 사용자 ID를 받고, 요청 본문에서 업데이트할 사용자 정보를 받는다.
	public Member updateMember(@PathVariable("id") Long id, @RequestBody Member updatedMember) {
		Member member = members.stream()
			.filter(m -> m.getId().equals(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다. Id: " + id));

		member.setName(updatedMember.getName());
		member.setEmail(updatedMember.getEmail());

		return member;
	}

	// DELETE /api/members/{commentId}
	@DeleteMapping("/{id}")
	// DELETE 요청을 처리하여 특정 ID에 해당하는 사용자 삭제, 경로 변수로 사용자 ID를 받는다.
	public void deleteMember(@PathVariable("id") Long id) {
		members.removeIf(member -> member.getId().equals(id));
	}
}