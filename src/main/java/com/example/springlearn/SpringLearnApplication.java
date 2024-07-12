package com.example.springlearn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

// @SpringBootApplication 어노테이션은 @Configuration, @EnableAutoConfiguration, @ComponentScan을 포함한다.
@SpringBootApplication
public class SpringLearnApplication {
	// application.properties 또는 application.yml에서 설정된 서버 포트를 주입받는다.
	@Value("${server.port}")
	private int port;

	// application.properties 또는 application.yml에서 설정된 애플리케이션 이름을 주입받는다.
	@Value("${spring.application.name}")
	private String appName;

	// 빈 초기화 후에 자동으로 실행되어 주입받은 설정 값들을 콘솔에 출력하는 메서드
	@PostConstruct
	public void printConfig() {
		System.out.println("서버 포트번호: " + port);
		System.out.println("스프링 애플리케이션 이름: " + appName);
	}

	// 애플리케이션의 진입점
	public static void main(String[] args) {
		// Spring Boot 애플리케이션 실행
		SpringApplication.run(SpringLearnApplication.class, args);
	}
}