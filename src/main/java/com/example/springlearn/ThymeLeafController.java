package com.example.springlearn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeLeafController {
	@GetMapping("/mapping1")
	public String example(Model model) {
		// 변수는 이름, 값의 쌍으로 추가
		model.addAttribute("text", "백엔드 오르미");
		model.addAttribute("name", "홍길동");

		return "index"; // html 파일명
	}

	@GetMapping("/mapping2")
	// ?name=값 ← 여기서 값이 아래 파라미터 name에 들어감
	// @RequestParam에서 name2로 바꾸면 ?name2=값 ← 이렇게 해야 함
	public String index(@RequestParam("name") String name, Model model) {
		model.addAttribute("text", "동적 페이지");
		model.addAttribute("name", name);
		return "index";
	}
}