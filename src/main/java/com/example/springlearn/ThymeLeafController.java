package com.example.springlearn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeLeafController {
	@GetMapping("/introduction")
	public String example(Model model) {
		// 변수는 이름, 값의 쌍으로 추가
		model.addAttribute("name", "안유석");
		model.addAttribute("age", 26);
		model.addAttribute("address", "경산");
		model.addAttribute("job", "취준생");
		model.addAttribute("bootcamp", "백엔드 오르미");

		return "index"; // html 파일명
	}
}