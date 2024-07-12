package com.example.springlearn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
	@Value("${server.port}")
	private int port;

	@Value("${spring.application.name}")
	private String appName;
}