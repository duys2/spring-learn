package com.example.springlearn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeLeafController {
	// application.yml에서 설정된 애플리케이션 이름 주입
	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/index.html")
	public String index(Model model) {
		model.addAttribute("text", "index.html");
		model.addAttribute("name", appName);

		return "index";
	}

	@GetMapping("/mapping1")
	public String mapping1(Model model) {
		// 변수는 이름, 값의 쌍으로 추가
		model.addAttribute("text", "백엔드 오르미");
		model.addAttribute("name", "홍길동");

		return "index"; // html 파일명
	}

	@GetMapping("/mapping2")
	// ?name=값 ← 여기서 값이 아래 파라미터 name에 들어감
	// @RequestParam에서 name2로 바꾸면 ?name2=값 ← 이렇게 해야 함
	public String mapping2(@RequestParam("name") String name, Model model) {
		model.addAttribute("text", "동적 페이지");
		model.addAttribute("name", name);
		return "index";
	}
}