package com.example.springlearn.psa;

public class AwsSesEmailSender implements EmailSender {
	@Override
	public void sendEmail(String to, String subject, String body) {
		// AWS SES를 사용하여 이메일 발송
		System.out.println("AWS SES: Sending email to " + to);
	}
}