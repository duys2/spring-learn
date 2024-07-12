package com.example.springlearn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Spring 애플리케이션의 설정 값을 주입받는 예시
@Component
public class TestComponent {
	// 서버의 포트 번호 주입받기: application.properties 또는 application.yml 파일의 server.port 값 사용
	@Value("${server.port}")
	private int port;

	// 스프링 애플리케이션의 이름 주입받기: application.properties 또는 application.yml 파일의 spring.application.name 값 사용
	@Value("${spring.application.name}")
	private String appName;
}