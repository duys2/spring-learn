package com.example.springlearn.post_crud;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 이 클래스는 Spring MVC 컨트롤러임을 나타냄
@Controller
// 이 컨트롤러의 모든 메서드에 대한 기본 URL 경로를 "/posts"로 설정
@RequestMapping("/posts")
public class PostController {
	// 게시물을 저장할 리스트 생성
	private List<Post> posts = new ArrayList<>();
	// 새 게시물에 할당할 다음 ID값
	private Long nextId = 1L;

	/* --------------- 게시글 목록 조회 --------------- */
	// GET /posts 요청을 처리: 모든 게시물 목록을 표시
	@GetMapping
	public String bookList(Model model) {
		// 뷰에서 사용할 수 있도록 게시물 리스트를 모델에 추가
		model.addAttribute("posts", posts);

		// "post/list" 뷰 반환
		return "post/list";
	}

	/* --------------- 게시글 생성 --------------- */
	// GET /posts/new 요청을 처리: 새 게시물 작성 폼 표시
	@GetMapping("/new")
	public String newPostForm(Model model) {
		// 뷰에서 사용할 수 있도록 새 Post 객체를 모델에 추가
		model.addAttribute("post", new Post());

		return "post/form";
	}

	// POST /posts 요청을 처리: 새 게시물 저장
	@PostMapping
	public String savePost(@ModelAttribute Post post) {
		// 새 게시물에 ID를 할당하고 nextId 증가
		post.setId(nextId++);

		// 게시물의 생성 시간을 현재 시간으로 설정
		post.setCreatedAt(LocalDateTime.now());

		// 게시물을 리스트에 추가
		posts.add(post);

		// 게시물 목록 페이지로 리다이렉트
		return "redirect:/posts";
	}

	/* --------------- 게시글 상세 조회 --------------- */
	// GET 요청으로 특정 ID의 게시글을 조회하는 메서드
	@GetMapping("/{id}") // /posts/{id} 형식의 URL 매핑
	// @PathVariable 어노테이션을 사용하여 URL의 {id}부분을 id 매개변수 받아 옴
	public String detail(@PathVariable Long id, Model model) {
		// posts 리스트에서 주어진 id와 일치하는 게시글을 찾음
		Post post = posts.stream()
			// 각 게시글의 id와 주어진 id를 비교
			.filter(p -> p.getId().equals(id))
			// 일치하는 첫 번째 게시글 선택
			.findFirst()
			// 일치하는 게시글이 없으면 예외 발생
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

		// 찾은 게시글을 model에 추가하여 view에서 사용할 수 있게 함
		model.addAttribute("post", post);

		// 게시글 상세 페이지(post/detail)를 보여주는 view 반환
		return "post/detail";
	}

	/* --------------- 게시글 수정 --------------- */
	// 게시글 수정 폼을 보여주는 메서드
	@GetMapping("/{id}/edit") // /posts/{id}/edit 형식의 URL 매핑
	public String editForm(@PathVariable("id") Long id, Model model) {
		// posts 리스트에서 주어진 id와 일치하는 게시글을 찾고
		Post post = posts.stream()
			.filter(p -> p.getId().equals(id))
			.findFirst()
			// 일치하는 게시글이 없으면 예외를 발생시킴
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

		// 찾은 게시글을 model에 추가하여 view에서 사용할 수 있게 함
		model.addAttribute("post", post);

		// 게시글 수정 폼 페이지(post/edit)를 보여주는 view 반환
		return "post/edit";
	}

	// 게시글 수정을 처리하는 메서드
	@PostMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute Post updatedPost) {
		// posts 리스트에서 주어진 id와 일치하는 게시글을 찾음
		Post post = posts.stream()
			.filter(p -> p.getId().equals(id))
			.findFirst()
			// 일치하는 게시글이 없으면 예외를 발생시킴
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

		// 찾은 게시글의 제목과 내용을 업데이트
		post.setTitle(updatedPost.getTitle());
		post.setContent(updatedPost.getContent());

		// 수정된 게시글의 상세 페이지로 리다이렉트(재요청)
		return "redirect:/posts/{id}";
	}

	/* --------------- 게시글 삭제 --------------- */
	// 게시글 삭제를 처리하는 메서드
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		// posts 리스트에서 주어진 id와 일치하는 게시글을 찾아 삭제
		// removeIf 메서드는 조건에 맞는 요소를 리스트에서 제거함
		posts.removeIf(post -> post.getId().equals(id));

		// 삭제 후 게시글 목록 페이지로 리다이렉트
		return "redirect:/posts";
	}
}