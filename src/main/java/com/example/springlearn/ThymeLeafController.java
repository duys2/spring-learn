package com.example.springlearn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springlearn.user.User;

@Controller
public class ThymeLeafController {
	/* --------------- 애플리케이션 이름 주입 --------------- */
	// application.yml파일에서 설정된 'spring.application.name'속성값(애플리케이션 이름)을 읽어와 appName필드에 주입
	@Value("${spring.application.name}")
	private String appName;

	/* --------------- SpringBoot + Thymeleaf Sample 코드 --------------- */
	// HTTP GET 요청을 "/sample" 경로로 매핑
	@GetMapping("/sample")
	// 클라이언트의 요청을 처리하는 메서드
	public String sample(Model model) {
		/* Model 객체를 사용하여 뷰에 데이터 전달
		Model 객체에 속성을 추가: 속성은 키(이름)와 값의 쌍으로 구성
		아래의 예시에서 "text"가 키(이름)이고, "백엔드 오르미"가 값
		"text"라는 이름으로 "백엔드 오르미"라는 문자열 값을 추가: 이 데이터는 뷰에서 ${text}로 접근할 수 있다. */
		model.addAttribute("text", "백엔드 오르미");

		/* "index"라는 이름의 뷰를 반환
		이는 일반적으로 index.html 또는 index.jsp 파일을 가리키며,
		뷰 리졸버가 이 문자열을 사용하여 실제 뷰 템플릿을 찾아 렌더링 */
		return "index";
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 변수 표현식 (Variable Expressions) --------------- */
	// "/syntax1" URL로 GET 요청이 오면 이 메서드로 처리
	@GetMapping("/syntax1")
	public String syntax1(Model model) {
		// "syntax"라는 이름으로 "변수 표현식 (Variable Expressions)"문자열을 모델에 추가
		model.addAttribute("syntax", "변수 표현식 (Variable Expressions)");
		// "file"라는 이름으로 "index.html"값을 모델에 추가
		model.addAttribute("file", "index.html");
		// "app"이라는 이름으로 appName변수의 값을 모델에 추가: 이를 통해 뷰 템플릿에서 ${app}으로 appName값에 접근 가능
		model.addAttribute("app", appName);

		// User 객체 생성: 이름 "syntax1", 이메일 "mapping@naver.com", 나이 15
		User user = new User("syntax1", "mapping@naver.com", 15);
		// 생성한 User 객체를 "user"라는 이름으로 모델에 추가하여 뷰에서 사용할 수 있게 함
		model.addAttribute("user", user);

		// "index"라는 이름의 뷰 템플릿을 반환 (실제로는 index.html 파일을 찾아 렌더링)
		return "index";  // html 파일명
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 선택 변수 표현식 (Selection Variable Expressions) --------------- */
	@GetMapping("/syntax2")
	public String syntax2(Model model) {
		model.addAttribute("syntax", "선택 변수 표현식 (Selection Variable Expressions)");
		model.addAttribute("file", "index.html");
		model.addAttribute("app", appName);

		User user = new User("syntax2", "mapping@naver.com", 30);
		model.addAttribute("user", user);

		return "index";
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 조건문 (Conditional Statements) --------------- */
	@GetMapping("/syntax3")
	public String syntax3(Model model) {
		model.addAttribute("syntax", "조건문 (Conditional Statements)");
		model.addAttribute("file", "index.html");
		model.addAttribute("app", appName);

		User user = new User("syntax3", "mapping@naver.com", 23);
		model.addAttribute("user", user);

		return "index";
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 반복문 (Iteration) --------------- */
	@GetMapping("/syntax4")
	public String syntax4(Model model) {
		model.addAttribute("syntax", "반복문 (Iteration)");
		model.addAttribute("file", "index.html");
		model.addAttribute("app", appName);

		User user = new User("syntax4", "mapping@naver.com", 47);
		model.addAttribute("user", user);

		int[] iterData = {1, 2, 3, 4, 5};
		model.addAttribute("iterData", iterData);

		return "index";
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 속성 설정 (Attribute Modification) --------------- */
	@GetMapping("/syntax5")
	public String syntax5(Model model) {
		model.addAttribute("syntax", "속성 설정 (Attribute Modification)");
		model.addAttribute("file", "index2.html");
		model.addAttribute("app", appName);

		// "index2"라는 이름의 뷰(일반적으로 index2.html)를 찾아 렌더링 (index2.html로 이동)
		return "index2"; // 경로는 src/main/resources/templates/index2.html이 됨
	}

	/* --------------- SpringBoot + Thymeleaf 문법: 폼 바인딩 (Form Binding) --------------- */
	@PostMapping("/syntax6")
	public String syntax6(@ModelAttribute User user, Model model) {
		model.addAttribute("syntax", "폼 바인딩 (Form Binding)");
		model.addAttribute("file", "index2.html");
		model.addAttribute("app", appName);

		System.out.println("유저의 이름은 " + user.getUserName() + "입니다.");
		System.out.println("유저의 이메일은 " + user.getEmail() + "입니다.");

		return "index2";
	}

	@GetMapping("/mapping")
	// ?name=값 ← 여기서 값이 아래 파라미터 name에 들어감
	// @RequestParam에서 name2로 바꾸면 ?name2=값 ← 이렇게 해야 함
	public String mapping(@RequestParam("name") String name, Model model) {
		model.addAttribute("text", "동적 페이지");
		model.addAttribute("name", name);

		return "index";
	}
}