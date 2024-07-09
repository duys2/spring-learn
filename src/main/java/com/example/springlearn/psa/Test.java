package com.example.springlearn.psa;

public class Test {
	public static void main(String[] args) {
		EmailService emailService = new EmailService(new AwsSesEmailSender());
		// 출력: AWS SES: Sending email to 철수
		emailService.sendEmail("철수", "7월 1일 강의 내용", "7월 1일 강의 내용 정리 파일");
	}
}