package com.example.springlearn.psa;

public class SmtpEmailSender implements EmailSender {
	@Override
	public void sendEmail(String to, String subject, String body) {
		// SMTP를 사용하여 이메일 발송
		System.out.println("SMTP: Sending email to " + to);
	}
}